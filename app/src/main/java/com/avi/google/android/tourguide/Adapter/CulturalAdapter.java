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

import com.avi.google.android.tourguide.Model.Cultural;
import com.avi.google.android.tourguide.R;
import com.avi.google.android.tourguide.Utils.Utils;

import java.util.ArrayList;

public class CulturalAdapter extends RecyclerView.Adapter<CulturalAdapter.culturalViewHolder> {
    private final Context context;
    private final ArrayList<Cultural> culturals;

    /**
     * Constructor to initialize the adapter with current context object and parks list
     *
     * @param context access to application-specific resources and classes
     * @param culturals   Getting culturals list
     */
    public CulturalAdapter(Context context, ArrayList<Cultural> culturals) {
        this.context = context;
        this.culturals = culturals;
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
    public culturalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new culturalViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_cultural_fragment, viewGroup, false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     *
     * @param culturalViewHolder which should be updated to represent the contents of the item at the given position in the data set
     * @param position       The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull final culturalViewHolder culturalViewHolder, int position) {

        //Storing the stable ID for the item at position
        final Cultural cultural = culturals.get(position);

        //Based on item position, storing the data accordingly
        culturalViewHolder.culturalImg.setImageResource(cultural.getculturalImageId());
        culturalViewHolder.culturalTitle.setText(cultural.getculturalTitle());
        culturalViewHolder.culturalAdventure.setText(cultural.getculturalAdventure());
        culturalViewHolder.culturalRating.setText(String.valueOf(cultural.getculturalRating()));
        culturalViewHolder.culturalRatingBar.setRating(cultural.getculturalRating());

        //Click Listener to open a detail intent, displaying more info about culturals
        culturalViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, cultural, culturalViewHolder.culturalImg);
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
        return culturals.size();
    }

    public static class culturalViewHolder extends RecyclerView.ViewHolder {

        // Variable declaration for views available on screen
        final ImageView culturalImg;
        final TextView culturalTitle;
        final TextView culturalRating;
        final RatingBar culturalRatingBar;
        final TextView culturalAdventure;
        final CardView cardView;

        culturalViewHolder(@NonNull View itemView) {
            super(itemView);

            // Fetching view IDs for view elements from resource
            culturalImg = itemView.findViewById(R.id.cultural_image);
            culturalTitle = itemView.findViewById(R.id.cultural_name);
            culturalRating = itemView.findViewById(R.id.rating);
            culturalRatingBar = itemView.findViewById(R.id.ratingBar);
            culturalAdventure = itemView.findViewById(R.id.cultural_address);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}