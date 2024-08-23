package com.hsbc.service;

import com.hsbc.Dao.ManagerDao;
import com.hsbc.Dao.ManagerDaoImpl;
import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.List;




public class ManagerServiceImpl implements ManagerService {

    private final ManagerDao managerDao;

    public ManagerServiceImpl() {
        this.managerDao = new ManagerDaoImpl();
    }

    @Override
    public boolean bookMeeting(Booking booking) {
        // Validate if the required amenities are available before booking
        if (!managerDao.validateAmenities(booking)) {
            System.out.println("Required amenities are not available for this booking.");
            return false;
        }

        // Proceed with booking
        return managerDao.bookMeeting(booking);
    }

    @Override
    public boolean addUserToMeeting(int bookingId, int userId) {
        return managerDao.addUserToMeeting(bookingId, userId);
    }

    @Override
    public List<User> searchUsers(String keyword) {
        return managerDao.searchUsers(keyword);
    }

    @Override
    public List<Booking> viewBookings(int managerId) {
        return managerDao.viewBookings(managerId);
    }

    @Override
    public Booking getMeetingDetails(int bookingId) {
        return managerDao.getMeetingDetails(bookingId);
    }
}
