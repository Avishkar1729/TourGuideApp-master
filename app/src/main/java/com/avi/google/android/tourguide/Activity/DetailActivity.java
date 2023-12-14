package com.avi.google.android.tourguide.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.avi.google.android.tourguide.Fragment.HotelDetailFragment;
import com.avi.google.android.tourguide.Fragment.AdventureDetailFragment;
import com.avi.google.android.tourguide.Fragment.ParksDetailFragment;
import com.avi.google.android.tourguide.Fragment.CulturalDetailFragment;
import com.avi.google.android.tourguide.Model.Adventure;
import com.avi.google.android.tourguide.Model.Hotel;
import com.avi.google.android.tourguide.Model.Parks;
import com.avi.google.android.tourguide.Model.Cultural;
import com.avi.google.android.tourguide.R;

public class DetailActivity extends AppCompatActivity {

    //Declaring a string to hold extra data passed through intent between MainActivity and DetailActivity
    public static final String INTENT_EXTRA = "extras";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Getting intent from MainActivity
        Object object = getIntent().getSerializableExtra(INTENT_EXTRA);
        Fragment fragment = null;

        //Verifying object type obtained from intent and instantiating fragments accordingly
        if (object instanceof Hotel) {
            fragment = HotelDetailFragment.newInstance((Hotel) object);
        } else if (object instanceof Adventure) {
            fragment = AdventureDetailFragment.newInstance((Adventure) object);
        } else if (object instanceof Cultural) {
            fragment = CulturalDetailFragment.newInstance((Cultural) object);
        } else if (object instanceof Parks) {
            fragment = ParksDetailFragment.newInstance((Parks) object);
        }

        //Using fragment manager that creates a transaction to reAdventure the container with required fragment
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
        }
    }

    /**
     * Called whenever the user chooses to navigate Up within your application's activity hierarchy from the action bar
     *
     * @return true if Up navigation completed successfully and this Activity was finished, false otherwise
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}