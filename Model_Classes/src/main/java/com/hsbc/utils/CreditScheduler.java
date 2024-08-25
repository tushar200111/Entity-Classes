package com.hsbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class CreditScheduler {

    public static void initializeCredits() {
        // Check if the credits need to be reset
        LocalDateTime lastResetDate = getLastResetDate();
        LocalDateTime lastMonday = LocalDateTime.now()
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                .withHour(6).withMinute(0).withSecond(0).withNano(0);

        if (lastResetDate == null || lastResetDate.isBefore(lastMonday)) {
            resetManagerCredits();
            updateLastResetDate(LocalDateTime.now());
        }
    }

    // Method to reset the credits of managers to 2000
    public static void resetManagerCredits() {
        String sql = "UPDATE Users SET credits = 2000 WHERE role = 'Manager'";

        try (Connection conn = DatabaseConnection.getLocalConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Credits reset for managers. Rows affected: " + rowsUpdated);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to fetch the last reset date from the database
    private static LocalDateTime getLastResetDate() {
        String sql = "SELECT MAX(change_date) AS last_reset_date FROM CreditsHistory WHERE reason = 'Weekly Reset'";

        try (Connection conn = DatabaseConnection.getLocalConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next() && rs.getTimestamp("last_reset_date") != null) {
                return rs.getTimestamp("last_reset_date").toLocalDateTime();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to update the last reset date in the database (log the reset)
    private static void updateLastResetDate(LocalDateTime resetDate) {
        String sql = "INSERT INTO CreditsHistory (change_amount, reason, change_date) " +
                     "VALUES ( 2000, 'Weekly Reset', ?)";

        try (Connection conn = DatabaseConnection.getLocalConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, java.sql.Timestamp.valueOf(resetDate));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
