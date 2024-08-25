package com.hsbc.Dao;

import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.List;

public interface ManagerDao {

    // Book a meeting room
    public boolean bookMeeting(Booking booking);

    // Add users to a meeting
    public boolean addUserToMeeting(int bookingId, int userId);

    // Search users by name
    public List<User> searchUsers(String keyword);

    // View all meetings booked by the manager
    public List<Booking> viewBookings(int managerId);

    // View details of a specific meeting
    public Booking getMeetingDetails(int bookingId);

    public boolean validateAmenities(Booking booking);
}