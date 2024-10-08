package com.hsbc.services;

import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.List;



public interface ManagerService {

    // Book a meeting room
    boolean bookMeeting(Booking booking);

    // Add users to a meeting
    boolean addUserToMeeting(int bookingId, int userId);

    // Search users by name
    List<User> searchUsers(String keyword);

    // View all meetings booked by the manager
    List<Booking> viewBookings(int managerId);

    // View details of a specific meeting
    Booking getMeetingDetails(int bookingId);
}
