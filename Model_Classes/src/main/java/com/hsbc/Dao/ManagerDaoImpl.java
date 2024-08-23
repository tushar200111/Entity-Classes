package com.hsbc.Dao;

import com.hsbc.model.Booking;
import com.hsbc.model.User;
import com.hsbc.model.Meeting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;





public class ManagerDaoImpl implements ManagerDao {
    private static final String URL = "jdbc:mysql://localhost:3306/meeting_db"; // Update with your database URL
    private static final String USER = "root"; // Update with your database username
    private static final String PASSWORD = "password"; // Update with your database password

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public boolean bookMeeting(Booking booking) {
        if (!validateAmenities(booking)) {
            return false; // Validation failed, booking cannot proceed
        }

        String sql = "INSERT INTO bookings (room_id, user_id, start_time, end_time, total_cost, type) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, booking.getRoomId());
            stmt.setInt(2, booking.getUserId());
            stmt.setTimestamp(3, Timestamp.valueOf(booking.getStartTime()));
            stmt.setTimestamp(4, Timestamp.valueOf(booking.getEndTime()));
            stmt.setInt(5, booking.getTotalCost());
            stmt.setString(6, booking.getType());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validateAmenities(Booking booking) {
        String sql = "SELECT amenities FROM meeting_rooms WHERE room_id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, booking.getRoomId());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                List<String> amenities = List.of(rs.getString("amenities").split(","));

                switch (booking.getType().toLowerCase()) {
                    case "classroom training":
                        return amenities.contains("whiteboard") && amenities.contains("projector");
                    case "online training":
                        return amenities.contains("wifi") && amenities.contains("projector");
                    case "conference call":
                        return amenities.contains("conference call facility");
                    case "business":
                        return amenities.contains("projector");
                    default:
                        return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addUserToMeeting(int bookingId, int userId) {
        String selectSql = "SELECT meeting_id FROM meetings WHERE booking_id = ?";
        String insertSql = "INSERT INTO meeting_users (meeting_id, user_id) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {
            selectStmt.setInt(1, bookingId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int meetingId = rs.getInt("meeting_id");

                try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                    insertStmt.setInt(1, meetingId);
                    insertStmt.setInt(2, userId);
                    int rowsAffected = insertStmt.executeUpdate();
                    return rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> searchUsers(String keyword) {
        String sql = "SELECT * FROM users WHERE name LIKE ?";
        List<User> users = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getLong("phone"),
                        rs.getString("role")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Booking> viewBookings(int managerId) {
        String sql = "SELECT * FROM bookings WHERE user_id = ?";
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, managerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("booking_id"),
                        rs.getInt("room_id"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getTimestamp("end_time").toLocalDateTime(),
                        rs.getInt("total_cost"),
                        rs.getString("type")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public Booking getMeetingDetails(int bookingId) {
        String sql = "SELECT * FROM bookings WHERE booking_id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Booking(
                        rs.getInt("booking_id"),
                        rs.getInt("room_id"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getTimestamp("end_time").toLocalDateTime(),
                        rs.getInt("total_cost"),
                        rs.getString("type")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
