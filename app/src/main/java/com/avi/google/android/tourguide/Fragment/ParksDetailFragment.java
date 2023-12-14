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

import com.avi.google.android.tourguide.Model.Parks;
import com.avi.google.android.tourguide.R;
import com.avi.google.android.tourguide.Utils.Utils;

import static com.avi.google.android.tourguide.Activity.DetailActivity.INTENT_EXTRA;

import org.w3c.dom.Text;

public class ParksDetailFragment extends Fragment implements View.OnClickListener {

    private Parks parks;

    /**
     * Creating a new instance of the fragment, replacing whatever current fragment instance is being shown
     *
     * @param parks reference to Model class
     * @return returns Fragment with Intent received from MainActivity
     */
    public static ParksDetailFragment newInstance(Parks parks) {
        ParksDetailFragment fragment = new ParksDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(INTENT_EXTRA, parks);
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
            Parks parks = (Parks) getArguments().getSerializable(INTENT_EXTRA);
            if (parks != null) {
                this.parks = parks;
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
        return inflater.inflate(R.layout.layout_parks_fg_detail, container, false);
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
        ImageView parksImg = view.findViewById(R.id.parksImage);
        TextView parksTitle = view.findViewById(R.id.title);
        TextView parksRating = view.findViewById(R.id.rating);
        RatingBar parksRatingBar = view.findViewById(R.id.ratingBar);
        TextView parksDirections = view.findViewById(R.id.directions);
        TextView parksPhone = view.findViewById(R.id.phone);
        TextView parksHours = view.findViewById(R.id.hours);
        TextView parksUrl = view.findViewById(R.id.website);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        TextView parksInfo = view.findViewById(R.id.about);
        TextView parksPlaces = view.findViewById(R.id.places);
        TextView parksHotels = view.findViewById(R.id.hotels);
        TextView parksHelpline = view.findViewById(R.id.helpline);

        //Setting up custom toolbar to show the clicked item title
        Utils.setUpToolbar(getActivity(), toolbar, parks.getparksTitle());

        //Click listener to handle view click events
        parksPhone.setOnClickListener(this);
        parksDirections.setOnClickListener(this);
        parksUrl.setOnClickListener(this);

        //Setting the data to appropriate item position
        parksImg.setImageResource(parks.getparksImageId());
        parksTitle.setText(parks.getparksTitle());
        parksRating.setText(String.valueOf(parks.getparksRating()));
        parksRatingBar.setRating(parks.getparksRating());
        parksPhone.setText(parks.getparksPhone());
        parksHours.setText(parks.getparksTime());
        parksDirections.setText(parks.getparksLocation());
        parksUrl.setText(parks.getparksWebsite());
        parksInfo.setText(parks.getparksInfo());
        parksPlaces.setText(parks.getparksPlaces());
        parksHotels.setText(parks.getparksHotels());
        parksHelpline.setText(parks.getparksHelpline());
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
                case R.id.directions:
                    Utils.directionsIntent(getContext(), parks.getparksLocation());
                    break;
                case R.id.phone:
                    Utils.phoneIntent(getContext(), parks.getparksPhone());
                    break;
                case R.id.website:
                    Utils.websiteIntent(getContext(), parks.getparksWebsite());
                    break;
            }
        }
    }
}