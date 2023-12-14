package com.avi.google.android.tourguide.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.avi.google.android.tourguide.Activity.DetailActivity;
import com.avi.google.android.tourguide.Activity.MainActivity;
import com.avi.google.android.tourguide.Model.Adventure;
import com.avi.google.android.tourguide.Model.Hotel;
import com.avi.google.android.tourguide.Model.Parks;
import com.avi.google.android.tourguide.Model.Cultural;
import com.avi.google.android.tourguide.R;

import java.util.Objects;

import static com.avi.google.android.tourguide.Activity.DetailActivity.INTENT_EXTRA;

public class Utils {

    /**
     * Method to refer object for which Fragment instantiated
     *
     * @param context   context object to get current application state
     * @param object    Fragment object reference
     * @param imageView Image to inflate on DetailActivity on click
     */
    public static void detailIntent(Context context, Object object, ImageView imageView) {
        Intent intent = new Intent(context, DetailActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((MainActivity) context, imageView, Objects.requireNonNull(ViewCompat.getTransitionName(imageView)));

        if (object instanceof Hotel) {
            Hotel hotel = (Hotel) object;
            intent.putExtra(INTENT_EXTRA, hotel);
        } else if (object instanceof Adventure) {
            Adventure Adventure = (Adventure) object;
            intent.putExtra(INTENT_EXTRA, Adventure);
        } else if (object instanceof Cultural) {
            Cultural cultural = (Cultural) object;
            intent.putExtra(INTENT_EXTRA, cultural);
        } else if (object instanceof Parks) {
            Parks parks = (Parks) object;
            intent.putExtra(INTENT_EXTRA, parks);
        }
        context.startActivity(intent, options.toBundle());
    }

    /**
     * Setting up toolbar based on Fragment item click
     *
     * @param context context object to get current application state
     * @param toolbar toolbar to be inflated as AppBar
     * @param title   title set based on item position
     */
    public static void setUpToolbar(Context context, Toolbar toolbar, String title) {
        if (context != null) {
            ((AppCompatActivity) context).setSupportActionBar(toolbar);
            ActionBar actionBar = ((AppCompatActivity) context).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(title);
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
            }
        }
    }

    /**
     * Method to refer object to pass Intent on displaying location
     * Check logic to show Toast if no location found
     *
     * @param context  context object to get current application state
     * @param location location to display
     */
    public static void directionsIntent(Context context, String location) {
        if (location.length() <= 0) {
            Toast.makeText(context, R.string.no_location, Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
        intent.setPackage("com.google.android.apps.maps");
        context.startActivity(intent);
    }

    /**
     * Method to refer object to pass Intent on dialling phone
     * Check logic to show Toast if no phone number found
     *
     * @param context context object to get current application state
     * @param phone   phone to dial
     */
    public static void phoneIntent(Context context, String phone) {
        if (phone.length() <= 0) {
            Toast.makeText(context, R.string.no_phone, Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        context.startActivity(intent);
    }

    /**
     * Method to refer object to pass Intent on web browser
     * Check logic to show Toast if no website url found
     *
     * @param context context object to get current application state
     * @param website website to display
     */
    public static void websiteIntent(Context context, String website) {
        if (website.length() <= 0) {
            Toast.makeText(context, R.string.no_website, Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        context.startActivity(intent);
    }
}