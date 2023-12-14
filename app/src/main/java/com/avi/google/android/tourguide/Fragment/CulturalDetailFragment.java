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

import com.avi.google.android.tourguide.Model.Cultural;
import com.avi.google.android.tourguide.R;
import com.avi.google.android.tourguide.Utils.Utils;

import static com.avi.google.android.tourguide.Activity.DetailActivity.INTENT_EXTRA;

public class CulturalDetailFragment extends Fragment implements View.OnClickListener {

    private Cultural cultural;

    /**
     * Creating a new instance of the fragment, replacing whatever current fragment instance is being shown
     *
     * @param cultural reference to Model class
     * @return returns Fragment with Intent received from MainActivity
     */
    public static CulturalDetailFragment newInstance(Cultural cultural) {
        CulturalDetailFragment fragment = new CulturalDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(INTENT_EXTRA, cultural);
        fragment.setArguments(bundle);
        return fragment;
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
            Cultural cultural = (Cultural) getArguments().getSerializable(INTENT_EXTRA);
            if (cultural != null) {
                this.cultural = cultural;
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
        return inflater.inflate(R.layout.layout_cultural_fg_detail, container, false);
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
        ImageView culturalImg = view.findViewById(R.id.culturalImage);
        TextView culturalTitle = view.findViewById(R.id.title);
        TextView culturalRating = view.findViewById(R.id.rating);
        RatingBar culturalRatingBar = view.findViewById(R.id.ratingBar);
        TextView culturalPhone = view.findViewById(R.id.phone);
        TextView culturalHours = view.findViewById(R.id.hours);
        TextView culturalDirections = view.findViewById(R.id.directions);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        TextView culturalInfo = view.findViewById(R.id.about);
        TextView culturalPlaces = view.findViewById(R.id.places);
        TextView culturalHotels = view.findViewById(R.id.hotels);
        TextView culturalHelpline = view.findViewById(R.id.helpline);

        //Setting up custom toolbar to show the clicked item title
        Utils.setUpToolbar(getActivity(), toolbar, cultural.getculturalTitle());

        //Click listener to handle view click events
        culturalPhone.setOnClickListener(this);
        culturalDirections.setOnClickListener(this);

        //Setting the data to appropriate item position
        culturalImg.setImageResource(cultural.getculturalImageId());
        culturalTitle.setText(cultural.getculturalTitle());
        culturalRating.setText(String.valueOf(cultural.getculturalRating()));
        culturalRatingBar.setRating(cultural.getculturalRating());
        culturalPhone.setText(cultural.getculturalPhone());
        culturalHours.setText(cultural.getculturalTime());
        culturalDirections.setText(cultural.getculturalLocation());
        culturalInfo.setText(cultural.getculturalInfo());
        culturalPlaces.setText(cultural.getculturalPlaces());
        culturalHotels.setText(cultural.getculturalHotels());
        culturalHelpline.setText(cultural.getculturalHelpline());

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
                    Utils.phoneIntent(getContext(), cultural.getculturalPhone());
                    break;
                case R.id.directions:
                    Utils.directionsIntent(getContext(), cultural.getculturalLocation());
                    break;
            }
        }
    }
}