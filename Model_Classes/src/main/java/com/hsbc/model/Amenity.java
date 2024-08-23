package com.hsbc.model;

public class Amenity {
    private int amenityId;
    private String amenityName;
    private int creditCost;

    public Amenity(int amenityId, String amenityName, int creditCost) {
        this.amenityId = amenityId;
        this.amenityName = amenityName;
        this.creditCost = creditCost;
    }

    public int getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(int amenityId) {
        this.amenityId = amenityId;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    public int getCreditCost() {
        return creditCost;
    }

    public void setCreditCost(int creditCost) {
        this.creditCost = creditCost;
    }

    @Override
    public String toString() {
        return "Amenity{" +
                "amenityId=" + amenityId +
                ", amenityName='" + amenityName + '\'' +
                ", creditCost=" + creditCost +
                '}';
    }
}