package com.hsbc.Dao;

import com.hsbc.model.*;

import java.util.List;


public interface AdminDao {

    // CRUD Operations for User
    public boolean createUser(User user);
    public User getUserById(int userId);
    public boolean updateUser(User user);
    public boolean deleteUser(int userId);
    public List<User> getAllUsers();

    // CRUD Operations for Amenity
    public boolean createAmenity(Amenity amenity);
    public Amenity getAmenityById(int amenityId);
    public boolean updateAmenity(Amenity amenity);
    public boolean deleteAmenity(int amenityId);
    public List<Amenity> getAllAmenities();

    // CRUD Operations for Meeting Room
    public boolean createMeetingRoom(MeetingRoom meetingRoom);
    public MeetingRoom getMeetingRoomById(int roomId);
    public boolean updateMeetingRoom(MeetingRoom meetingRoom);
    public boolean deleteMeetingRoom(int roomId);
    public List<MeetingRoom> getAllMeetingRooms();

    // Get Booking and meeting Details
    public List<Booking> getBookingDetails(int bookingId);
    public Meeting getMeetingDetails(int MeetingId);
}