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

import com.avi.google.android.tourguide.Model.Adventure;
import com.avi.google.android.tourguide.R;
import com.avi.google.android.tourguide.Utils.Utils;

import java.util.ArrayList;

public class AdventureAdapter extends RecyclerView.Adapter<AdventureAdapter.adventureViewHolder> {

    private final ArrayList<Adventure> adventure;
    private final Context context;

    /**
     * Constructor to initialize the adapter with current context object and Hotels list
     *
     * @param context access to application-specific resources and classes
     * @param adventure  getting adventure list
     */
    public AdventureAdapter(ArrayList<Adventure> adventure, Context context) {
        this.adventure = adventure;
        this.context = context;
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item
     * Inflating adventure fragment layout
     *
     * @param viewGroup ViewGroup into which the new View will be added after it is bound to an adapter position
     * @param viewType  the view type of the new View
     * @return returns a new ViewHolder that holds a View of the given view type
     */
    @NonNull
    @Override
    public adventureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new adventureViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.layout_adventure_fragment, viewGroup, false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     *
     * @param adventureViewHolder which should be updated to represent the contents of the item at the given position in the data set
     * @param position         The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull final adventureViewHolder adventureViewHolder, final int position) {

        //Storing the stable ID for the item at position
        final Adventure Adventure = adventure.get(position);

        //Based on item position, storing the data accordingly
        adventureViewHolder.AdventureTitle.setText(Adventure.getAdventureTitle());
        adventureViewHolder.AdventureImg.setImageResource(Adventure.getAdventureImageId());
        adventureViewHolder.AdventureRating.setText(String.valueOf(Adventure.getAdventureRating()));
        adventureViewHolder.AdventureRatingBar.setRating(Adventure.getAdventureRating());
        adventureViewHolder.AdventureType.setText(Adventure.getAdventureType());

        //Click Listener to open a detail intent, displaying more info about adventure
        adventureViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, Adventure, adventureViewHolder.AdventureImg);
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
        return adventure.size();
    }

    public static class adventureViewHolder extends RecyclerView.ViewHolder {

        // Variable declaration for views available on screen
        final TextView AdventureTitle;
        final ImageView AdventureImg;
        final TextView AdventureRating;
        final RatingBar AdventureRatingBar;
        final TextView AdventureType;
        final CardView cardView;

        adventureViewHolder(@NonNull View itemView) {
            super(itemView);

            // Fetching view IDs for view elements from resource
            AdventureTitle = itemView.findViewById(R.id.Adventure_name);
            AdventureImg = itemView.findViewById(R.id.Adventure_image);
            AdventureRating = itemView.findViewById(R.id.rating);
            AdventureRatingBar = itemView.findViewById(R.id.ratingBar);
            AdventureType = itemView.findViewById(R.id.Adventure_type);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}