package com.avi.google.android.tourguide.Data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.avi.google.android.tourguide.Model.Cultural;
import com.avi.google.android.tourguide.R;

import java.util.ArrayList;

public class CulturalData {

    //Method to fetch values from resources bundle
    public static ArrayList<Cultural> fetchculturalData(Context context) {

        ArrayList<Cultural> culturals = new ArrayList<>();
        Resources resources = context.getResources();

        //Logic to fetch and store culturals Drawable
        TypedArray typedArray = resources.obtainTypedArray(R.array.culturalImgId);
        int[] culturalImgId = new int[typedArray.length()];
        for (int index = 0; index < culturalImgId.length; index++) {
            culturalImgId[index] = typedArray.getResourceId(index, 0);
        }

        //Logic to fetch and store culturals Rating
        typedArray = resources.obtainTypedArray(R.array.culturalRating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();

        //Getting values from string-arrays to store data
        String[] name = resources.getStringArray(R.array.culturalName);
        String[] Adventure = resources.getStringArray(R.array.culturalAdventure);
        String[] time = resources.getStringArray(R.array.culturalTime);
        String[] phone = resources.getStringArray(R.array.culturalPhone);
        String[] address = resources.getStringArray(R.array.culturalAddress);
        String[] info = resources.getStringArray(R.array.culturalInfo);
        String[] places = resources.getStringArray(R.array.culturalPlaces);
        String[] hotels = resources.getStringArray(R.array.culturalHotels);
        String[] helpline = resources.getStringArray(R.array.culturalHelpline);

        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < culturalImgId.length; i++) {
            Cultural cultural = new Cultural(culturalImgId[i], name[i], rating[i], phone[i], Adventure[i], time[i], address[i], info[i], places[i], hotels[i], helpline[i]);
            culturals.add(cultural);
        }
        return culturals;
    }
}