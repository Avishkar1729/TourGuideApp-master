package com.avi.google.android.tourguide.Data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.avi.google.android.tourguide.Model.Adventure;
import com.avi.google.android.tourguide.R;

import java.util.ArrayList;

public class AdventureData {

    //Method to fetch values from resources bundle
    public static ArrayList<Adventure> fetchAdventureData(Context context) {

        ArrayList<Adventure> Adventures = new ArrayList<>();
        Resources resources = context.getResources();

        //Logic to fetch and store Adventure Drawable
        TypedArray typedArray = resources.obtainTypedArray(R.array.AdventureImageId);
        int[] AdventureImgId = new int[typedArray.length()];
        for (int index = 0; index < AdventureImgId.length; index++) {
            AdventureImgId[index] = typedArray.getResourceId(index, 0);
        }

        //Logic to fetch and store Adventure Rating
        typedArray = resources.obtainTypedArray(R.array.AdventureRating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();

        //Getting values from string-arrays to store data
        String[] name = resources.getStringArray(R.array.AdventureName);
        String[] type = resources.getStringArray(R.array.AdventureType);
        String[] time = resources.getStringArray(R.array.AdventureTime);
        String[] phone = resources.getStringArray(R.array.AdventurePhone);
        String[] address = resources.getStringArray(R.array.AdventureAddress);
        String[] info = resources.getStringArray(R.array.AdventureInfo);
        String[] places = resources.getStringArray(R.array.AdventurePlaces);
        String[] hotels = resources.getStringArray(R.array.AdventureHotels);
        String[] helpline = resources.getStringArray(R.array.AdventureHelpline);

        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < AdventureImgId.length; i++) {
            Adventure Adventure = new Adventure(AdventureImgId[i], name[i], rating[i], type[i], time[i], phone[i], address[i], info[i], places[i], hotels[i], helpline[i]);
            Adventures.add(Adventure);
        }
        return Adventures;
    }
}