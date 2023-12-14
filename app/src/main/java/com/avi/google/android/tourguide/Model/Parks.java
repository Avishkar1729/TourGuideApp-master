package com.avi.google.android.tourguide.Model;

import java.io.Serializable;

public class Parks implements Serializable {
    private final int parksImageId;
    private final String parksTitle;
    private final float parksRating;
    private final String parksType;
    private final String parksPhone;
    private final String parksTime;
    private final String parksLocation;
    private final String parksWebsite;
    private final String parksInfo;
    private final String parksPlaces;
    private final String parksHotels;
    private final String parksHelpline;

    public Parks(int imageId, String title, float rating, String type, String phone, String time, String location, String website, String info, String places, String hotels, String helpline) {
        this.parksImageId = imageId;
        this.parksTitle = title;
        this.parksRating = rating;
        this.parksType = type;
        this.parksPhone = phone;
        this.parksTime = time;
        this.parksLocation = location;
        this.parksWebsite = website;
        this.parksInfo = info;
        this.parksPlaces = places;
        this.parksHotels = hotels;
        this.parksHelpline = helpline;
    }

    public int getparksImageId() {
        return parksImageId;
    }

    public String getparksTitle() {
        return parksTitle;
    }

    public float getparksRating() {
        return parksRating;
    }

    public String getparksType() {
        return parksType;
    }

    public String getparksPhone() {
        return parksPhone;
    }

    public String getparksTime() {
        return parksTime;
    }

    public String getparksLocation() {
        return parksLocation;
    }

    public String getparksWebsite() {
        return parksWebsite;
    }

    public String getparksInfo() {

        return parksInfo;
    }

    public String getparksPlaces() {
        return parksPlaces;
    }

    public String getparksHotels() {
        return parksHotels;
    }

    public String getparksHelpline() {
        return parksHelpline;
    }
}