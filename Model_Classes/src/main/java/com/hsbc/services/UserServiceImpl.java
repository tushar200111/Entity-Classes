package com.hsbc.services;

import com.hsbc.Dao.UserDao;
import com.hsbc.Dao.UserDaoImpl;
import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<Booking> viewUserMeetings(int userId) {
        return userDao.viewUserMeetings(userId);
    }


    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }
}