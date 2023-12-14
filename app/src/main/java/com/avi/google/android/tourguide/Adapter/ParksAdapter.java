package com.avi.google.android.tourguide.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.avi.google.android.tourguide.Model.Parks;
import com.avi.google.android.tourguide.R;
import com.avi.google.android.tourguide.Utils.Utils;

import java.util.ArrayList;

public class ParksAdapter extends RecyclerView.Adapter<ParksAdapter.parksViewHolder> {
    private final Context context;
    private final ArrayList<Parks> parks;

    /**
     * Constructor to initialize the adapter with current context object and parks list
     *
     * @param context     access to application-specific resources and classes
     * @param parks Getting parks list
     */
    public ParksAdapter(Context context, ArrayList<Parks> parks) {
        this.context = context;
        this.parks = parks;
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item
     * Inflating parks fragment layout
     *
     * @param viewGroup ViewGroup into which the new View will be added after it is bound to an adapter position
     * @param viewType  the view type of the new View
     * @return returns a new ViewHolder that holds a View of the given view type
     */
    @NonNull
    @Override
    public parksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new parksViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_parks_fragment, viewGroup, false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     *
     * @param parksViewHolder which should be updated to represent the contents of the item at the given position in the data set
     * @param position             The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull final parksViewHolder parksViewHolder, int position) {

        //Storing the stable ID for the item at position
        final Parks parks = this.parks.get(position);

        //Based on item position, storing the data accordingly
        parksViewHolder.parksImg.setImageResource(parks.getparksImageId());
        parksViewHolder.parksTitle.setText(parks.getparksTitle());
        parksViewHolder.parksType.setText(parks.getparksType());
        parksViewHolder.parksRating.setText(String.valueOf(parks.getparksRating()));
        parksViewHolder.parksRatingBar.setRating(parks.getparksRating());

        //Click Listener to open a detail intent, displaying more info about parks
        parksViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, parks, parksViewHolder.parksImg);
            }
        });
    }

    /**
     * Method to count number of items in data set
     *
     * @return returns the total number of items in the data set held by the adapter
     */
    @Override
    public int getItemCount() {
        return parks.size();
    }

    public static class parksViewHolder extends RecyclerView.ViewHolder {

        // Variable declaration for views available on screen
        final ImageView parksImg;
        final TextView parksTitle;
        final TextView parksType;
        final TextView parksRating;
        final RatingBar parksRatingBar;
        final CardView cardView;

        parksViewHolder(@NonNull View itemView) {
            super(itemView);

            // Fetching view IDs for view elements from resource
            parksImg = itemView.findViewById(R.id.parks_image);
            parksTitle = itemView.findViewById(R.id.parks_name);
            parksType = itemView.findViewById(R.id.parks_type);
            parksRating = itemView.findViewById(R.id.rating);
            parksRatingBar = itemView.findViewById(R.id.ratingBar);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}