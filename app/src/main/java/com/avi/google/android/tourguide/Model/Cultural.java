package com.avi.google.android.tourguide.Model;

import java.io.Serializable;

/**
 * Model class to get and set cultural Data with Adapter
 */
public class Cultural implements Serializable {
    private final int culturalImageId;
    private final String culturalTitle;
    private final float culturalRating;
    private final String culturalPhone;
    private final String culturalAdventure;
    private final String culturalTime;
    private final String culturalLocation;
    private final String culturalInfo;
    private final String culturalPlaces;
    private final String culturalHotels;
    private final String culturalHelpline;

    public Cultural(int imageId, String title, float rating, String phone, String Adventure, String time, String location, String info, String places, String hotels, String helpline) {
        this.culturalImageId = imageId;
        this.culturalTitle = title;
        this.culturalRating = rating;
        this.culturalPhone = phone;
        this.culturalAdventure = Adventure;
        this.culturalTime = time;
        this.culturalLocation = location;
        this.culturalInfo = info;
        this.culturalPlaces = places;
        this.culturalHotels = hotels;
        this.culturalHelpline = helpline;
    }

    public int getculturalImageId() {
        return culturalImageId;
    }

    public String getculturalTitle() {
        return culturalTitle;
    }

    public float getculturalRating() {
        return culturalRating;
    }

    public String getculturalPhone() {
        return culturalPhone;
    }

    public String getculturalAdventure() {
        return culturalAdventure;
    }

    public String getculturalTime() {
        return culturalTime;
    }

    public String getculturalLocation() {
        return culturalLocation;
    }

    public String getculturalInfo() {
        return culturalInfo;
    }

    public String getculturalPlaces() {
        return culturalPlaces;
    }

    public String getculturalHotels() {
        return culturalHotels;
    }

    public String getculturalHelpline() {
        return culturalHelpline;
    }
}