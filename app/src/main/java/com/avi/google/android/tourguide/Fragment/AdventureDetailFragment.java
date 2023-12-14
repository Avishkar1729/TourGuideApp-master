package com.avi.google.android.tourguide.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.avi.google.android.tourguide.Model.Adventure;
import com.avi.google.android.tourguide.R;
import com.avi.google.android.tourguide.Utils.Utils;

import static com.avi.google.android.tourguide.Activity.DetailActivity.INTENT_EXTRA;

public class AdventureDetailFragment extends Fragment implements View.OnClickListener {

    private Adventure Adventure;

    /**
     * Creating a new instance of the fragment, replacing whatever current fragment instance is being shown
     *
     * @param Adventure reference to Model class
     * @return returns Fragment with Intent received from MainActivity
     */
    public static AdventureDetailFragment newInstance(Adventure Adventure) {
        AdventureDetailFragment AdventureDetailFragment = new AdventureDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(INTENT_EXTRA, Adventure);
        AdventureDetailFragment.setArguments(bundle);
        return AdventureDetailFragment;
    }

    /**
     * Called to do initial creation of a fragment
     *
     * @param savedInstanceState If the fragment is being re-created from a previous saved state, this is the state
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Adventure Adventure = (Adventure) getArguments().getSerializable(INTENT_EXTRA);
            if (Adventure != null) {
                this.Adventure = Adventure;
            }
        }
    }

    /**
     * Called to have the fragment instantiate its user interface view
     * Inflating the fragment layout to show Intent data received from MainActivity
     *
     * @param inflater           to inflate any views in the fragment
     * @param container          viewGroup to which the new layout is to be attached
     * @param savedInstanceState reference to savedInstanceState using which saved fragment state can be parksred
     * @return returns the View for the fragment's UI, or null
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_adventure_fg_detail, container, false);
    }

    /**
     * Called immediately after onCreateView(LayoutInflater, ViewGroup, Bundle) has returned
     *
     * @param view               the View returned by onCreateView(LayoutInflater, ViewGroup, Bundle)
     * @param savedInstanceState reference to savedInstanceState using which saved fragment state can be parksred
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Fetching view IDs for elements from resource
        ImageView AdventureImg = view.findViewById(R.id.AdventureImage);
        TextView AdventureTitle = view.findViewById(R.id.title);
        TextView AdventureRating = view.findViewById(R.id.rating);
        RatingBar AdventureRatingBar = view.findViewById(R.id.ratingBar);
        TextView AdventurePhone = view.findViewById(R.id.phone);
        TextView AdventureHours = view.findViewById(R.id.hours);
        TextView AdventureDirections = view.findViewById(R.id.directions);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        TextView AdventureInfo = view.findViewById(R.id.about);
        TextView AdventurePlaces = view.findViewById(R.id.places);
        TextView AdventureHotels = view.findViewById(R.id.hotels);
        TextView AdventureHelpline = view.findViewById(R.id.helpline);

        //Setting up custom toolbar to show the clicked item title
        Utils.setUpToolbar(getActivity(), toolbar, Adventure.getAdventureTitle());

        //Click listener to handle view click events
        AdventurePhone.setOnClickListener(this);
        AdventureDirections.setOnClickListener(this);

        //Setting the data to appropriate item position
        AdventureImg.setImageResource(Adventure.getAdventureImageId());
        AdventureTitle.setText(Adventure.getAdventureTitle());
        AdventurePhone.setText(Adventure.getAdventurePhone());
        AdventureHours.setText(Adventure.getAdventureTime());
        AdventureRating.setText(String.valueOf(Adventure.getAdventureRating()));
        AdventureRatingBar.setRating(Adventure.getAdventureRating());
        AdventureDirections.setText(Adventure.getAdventureLocation());
        AdventureInfo.setText(Adventure.getAdventureInfo());
        AdventurePlaces.setText(Adventure.getAdventurePlaces());
        AdventureHotels.setText(Adventure.getAdventureHotels());
        AdventureHelpline.setText(Adventure.getAdventureHelpline());
    }

    /**
     * Handling click events on views
     *
     * @param view view object of clicked element
     */
    @Override
    public void onClick(View view) {
        if (getContext() != null) {
            switch (view.getId()) {
                case R.id.phone:
                    Utils.phoneIntent(getContext(), Adventure.getAdventurePhone());
                    break;
                case R.id.directions:
                    Utils.directionsIntent(getContext(), Adventure.getAdventureLocation());
                    break;
            }
        }
    }
}