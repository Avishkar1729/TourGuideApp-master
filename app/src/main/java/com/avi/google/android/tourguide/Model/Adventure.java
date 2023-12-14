package com.avi.google.android.tourguide.Model;

import java.io.Serializable;

/**
 * Model class to get and set Adventure Data with Adapter
 */
public class Adventure implements Serializable {
    private final int AdventureImageId;
    private final String AdventureTitle;
    private final float AdventureRating;
    private final String AdventureType;
    private final String AdventureTime;
    private final String AdventurePhone;
    private final String AdventureLocation;
    private final String AdventureInfo;
    private final String AdventurePlaces;
    private final String AdventureHotels;
    private final String AdventureHelpline;


    public Adventure(int imageId, String title, float rating, String type, String time, String phone, String location, String info, String places, String hotels, String helpline) {
        this.AdventureImageId = imageId;
        this.AdventureTitle = title;
        this.AdventureRating = rating;
        this.AdventureType = type;
        this.AdventurePhone = phone;
        this.AdventureTime = time;
        this.AdventureLocation = location;
        this.AdventureInfo = info;
        this.AdventurePlaces = places;
        this.AdventureHotels = hotels;
        this.AdventureHelpline = helpline;

    }

    public int getAdventureImageId() {
        return AdventureImageId;
    }

    public String getAdventureTitle() {
        return AdventureTitle;
    }

    public float getAdventureRating() {
        return AdventureRating;
    }

    public String getAdventureType() {
        return AdventureType;
    }

    public String getAdventurePhone() {
        return AdventurePhone;
    }

    public String getAdventureTime() {
        return AdventureTime;
    }

    public String getAdventureLocation() {
        return AdventureLocation;
    }

    public String getAdventureInfo() {
        return AdventureInfo;
    }

    public String getAdventurePlaces() {
        return AdventurePlaces;
    }

    public String getAdventureHotels() {
        return AdventureHotels;
    }

    public String getAdventureHelpline() {
        return AdventureHelpline;
    }
}