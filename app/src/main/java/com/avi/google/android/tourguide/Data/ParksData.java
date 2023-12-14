package com.avi.google.android.tourguide.Data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.avi.google.android.tourguide.Model.Parks;
import com.avi.google.android.tourguide.R;

import java.util.ArrayList;

public class ParksData {

    //Method to fetch values from resources bundle
    public static ArrayList<Parks> fetchparksData(Context context) {

        ArrayList<Parks> parks = new ArrayList<>();
        Resources resources = context.getResources();

        //Logic to fetch and store parks Drawable
        TypedArray typedArray = resources.obtainTypedArray(R.array.parksImgId);
        int[] parksImgId = new int[typedArray.length()];
        for (int index = 0; index < parksImgId.length; index++) {
            parksImgId[index] = typedArray.getResourceId(index, 0);
        }

        //Logic to fetch and store parks Rating
        typedArray = resources.obtainTypedArray(R.array.parksRating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();

        //Getting values from string-arrays to store data
        String[] name = resources.getStringArray(R.array.parksName);
        String[] time = resources.getStringArray(R.array.parksTime);
        String[] phone = resources.getStringArray(R.array.parksPhone);
        String[] type = resources.getStringArray(R.array.parksType);
        String[] address = resources.getStringArray(R.array.parksAddress);
        String[] url = resources.getStringArray(R.array.parksUrl);
        String[] info = resources.getStringArray(R.array.parksInfo);
        String[] places = resources.getStringArray(R.array.parksPlaces);
        String[] hotels = resources.getStringArray(R.array.parksHotels);
        String[] helpline = resources.getStringArray(R.array.parksHelpline);

        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < parksImgId.length; i++) {
            Parks park = new Parks(parksImgId[i], name[i], rating[i], type[i], phone[i], time[i], address[i], url[i], info[i], places[i], hotels[i], helpline[i]);
            parks.add(park);
        }
        return parks;
    }
}