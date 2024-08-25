package com.hsbc.services;

import com.hsbc.model.Amenity;
import com.hsbc.model.Booking;
import com.hsbc.model.MeetingRoom;
import com.hsbc.model.User;

import java.util.List;

public interface AdminService {
    public boolean addUser(User user);
    public User findUserById(int userId);
    public boolean updateUser(User user);
    public boolean removeUser(int userId);
    public List<User> getAllMemebrs();

    public boolean createAmenity(Amenity amenity);
    public Amenity getAmenityById(int amenityId);
    public boolean updateAmenity(Amenity amenity);
    public boolean RemoveAmenity(int amenityId);
    public List<Amenity> getAllAmenities();

    public boolean makeMeetingRoom(MeetingRoom meetingRoom);
    public MeetingRoom getMeetingRoomById(int roomId);
    public boolean updateMeetingRoom(MeetingRoom meetingRoom);
    public boolean deleteMeetingRoom(int roomId);
    public List<MeetingRoom> getAllMeetingRooms();

    public List<Booking> getBookingDetails();
}
