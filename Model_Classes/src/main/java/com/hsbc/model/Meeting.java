package com.hsbc.model;

import java.util.ArrayList;
import java.util.List;

public class Meeting {
    private String title;
    private String type;
    private int userId;
    private List<User> attendes = new ArrayList<>();
    private Booking booking;

    public Meeting(Booking booking, int userId, String type, String title) {
        this.booking = booking;
        this.userId = userId;
        this.type = type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setAttendes(User attende){
        attendes.add(attende);
    }

    public List<User> getAttendes() {
        return attendes;
    }
}
