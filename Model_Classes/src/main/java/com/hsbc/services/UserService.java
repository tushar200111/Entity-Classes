package com.hsbc.services;

import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.List;

public interface UserService {
    List<Booking> viewUserMeetings(int userId);
    User getUserById(int userId);
}