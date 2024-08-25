package com.hsbc.model;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private int roomId;
    private String roomName;
    private int seatingCapacity;
    private String amenties;

    public String getAmenties() {
        return amenties;
    }

    public void setAmenties(String amenties) {
        this.amenties = amenties;
    }

    public MeetingRoom(int roomId, int seatingCapacity, String roomName,String amenties) {
        this.roomId = roomId;
        this.seatingCapacity = seatingCapacity;
        this.roomName = roomName;
        this.amenties = amenties;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

}
