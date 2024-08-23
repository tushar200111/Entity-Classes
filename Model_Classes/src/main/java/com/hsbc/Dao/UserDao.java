package com.hsbc.Dao;

import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.List;

public interface UserDao {


    public List<Booking> viewUserMeetings(int userId);

    public Booking getUserMeetingDetails(int bookingId, int userId);

    public User getUserById(int userId);
}