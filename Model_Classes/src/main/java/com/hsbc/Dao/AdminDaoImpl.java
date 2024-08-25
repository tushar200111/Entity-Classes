package com.hsbc.Dao;

import com.hsbc.Dao.AdminDao;
import com.hsbc.model.*;
import com.hsbc.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    private Connection getConnection() {
        return DatabaseConnection.getLocalConnection();
    }

    // CRUD Operations for User
    @Override
    public boolean createUser(User user) {
        String sql = "INSERT INTO users (name, email, phone, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhone());
            stmt.setString(4, user.getRole());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("email"),
                        rs.getString("phone"), rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, phone = ?, role = ?,credits = ? WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhone());
            stmt.setString(4, user.getRole());
            stmt.setInt(5, user.getCredits());
            stmt.setInt(6, user.getUserId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("email"),
                        rs.getString("phone"), rs.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // CRUD Operations for Amenity
    @Override
    public boolean createAmenity(Amenity amenity) {
        String sql = "INSERT INTO amenities (amenity_name, credit_cost) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, amenity.getAmenityName());
            stmt.setInt(2, amenity.getCreditCost());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Amenity getAmenityById(int amenityId) {
        String sql = "SELECT * FROM amenities WHERE amenity_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, amenityId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Amenity(rs.getInt("amenity_id"), rs.getString("amenity_name"), rs.getInt("credit_cost"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateAmenity(Amenity amenity) {
        String sql = "UPDATE amenities SET amenity_name = ?, credit_cost = ? WHERE amenity_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, amenity.getAmenityName());
            stmt.setInt(2, amenity.getCreditCost());
            stmt.setInt(3, amenity.getAmenityId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAmenity(int amenityId) {
        String sql = "DELETE FROM amenities WHERE amenity_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, amenityId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Amenity> getAllAmenities() {
        String sql = "SELECT * FROM amenities";
        List<Amenity> amenities = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                amenities.add(new Amenity(rs.getInt("amenity_id"), rs.getString("amenity_name"), rs.getInt("credit_cost")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amenities;
    }

    // CRUD Operations for Meeting Room
    @Override
    public boolean createMeetingRoom(MeetingRoom meetingRoom) {
        String sql = "INSERT INTO meeting_rooms (room_name, seating_capacity, amenities) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, meetingRoom.getRoomName());
            stmt.setInt(2, meetingRoom.getSeatingCapacity());
            stmt.setString(3, meetingRoom.getAmenties());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public MeetingRoom getMeetingRoomById(int roomId) {
        String sql = "SELECT * FROM meeting_rooms WHERE room_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, roomId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new MeetingRoom(rs.getInt("room_id"), rs.getInt("seating_capacity"), rs.getString("room_name"),rs.getString("amenities"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateMeetingRoom(MeetingRoom meetingRoom) {
        String sql = "UPDATE meeting_rooms SET room_name = ?, seating_capacity = ?,amenities = ? WHERE room_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, meetingRoom.getRoomName());
            stmt.setInt(2, meetingRoom.getSeatingCapacity());
            stmt.setString(3, meetingRoom.getAmenties());
            stmt.setInt(4, meetingRoom.getRoomId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMeetingRoom(int roomId) {
        String sql = "DELETE FROM meeting_rooms WHERE room_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, roomId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<MeetingRoom> getAllMeetingRooms() {
        String sql = "SELECT * FROM meeting_rooms";
        List<MeetingRoom> rooms = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rooms.add(new MeetingRoom(rs.getInt("room_id"), rs.getInt("seating_capacity"), rs.getString("room_name"),rs.getString("amenities")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    // Get Booking Details
    @Override
    public List<Booking> getBookingDetails() {
        String sql = "SELECT * FROM Bookings";
        List<Booking> bookings = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Retrieve Booking information
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
    public Meeting getMeetingDetails(int MeetingId) {
        return null;
    }
}