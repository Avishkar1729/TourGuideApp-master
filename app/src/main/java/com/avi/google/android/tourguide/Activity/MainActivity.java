package com.avi.google.android.tourguide.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.avi.google.android.tourguide.Adapter.TabAdapter;
import com.avi.google.android.tourguide.Fragment.HotelFragment;
import com.avi.google.android.tourguide.Fragment.AdventureFragment;
import com.avi.google.android.tourguide.Fragment.ParksFragment;
import com.avi.google.android.tourguide.Fragment.CulturalFragment;
import com.avi.google.android.tourguide.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fetching view IDs from resource
        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);

        // Registering TabLayout with FragmentManager
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());

        // Adding Fragment with help of TabLayout adapter
        tabAdapter.addFragment(new AdventureFragment(), getString(R.string.Adventure));
        tabAdapter.addFragment(new CulturalFragment(), getString(R.string.cultural));
        tabAdapter.addFragment(new ParksFragment(), getString(R.string.parks));
        tabAdapter.addFragment(new HotelFragment(), getString(R.string.hotels));

        //Setting the Fragments with ViewPager
        viewPager.setAdapter(tabAdapter);

        //Setting up TabLayout with ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }
}