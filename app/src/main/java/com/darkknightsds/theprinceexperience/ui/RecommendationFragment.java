package com.darkknightsds.theprinceexperience.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darkknightsds.theprinceexperience.R;
import com.darkknightsds.theprinceexperience.models.Recommendation;

import org.parceler.Parcels;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendationFragment extends Fragment {


    public RecommendationFragment() {}

    public static RecommendationFragment newInstance(Recommendation recommendation) {
        RecommendationFragment recommendationFragment = new RecommendationFragment();
        Bundle args = new Bundle();
        args.putParcelable("recommendation", Parcels.wrap(recommendation));
        recommendationFragment.setArguments(args);
        return recommendationFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommendation, container, false);
    }

}
