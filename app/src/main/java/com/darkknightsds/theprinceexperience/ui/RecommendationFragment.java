package com.darkknightsds.theprinceexperience.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.darkknightsds.theprinceexperience.R;
import com.google.firebase.database.DatabaseReference;

import butterknife.BindView;
import butterknife.Unbinder;

public class RecommendationFragment extends Fragment {
    @BindView(R.id.recommendationImage) ImageView mRecoImage;
    @BindView(R.id.recommendationTitle) TextView mRecoTitle;
    @BindView(R.id.albumsRecycler) RecyclerView mAlbumsRecycler;

    private Unbinder unbinder;
    private DatabaseReference mRecoRef;
    private DatabaseReference rootRef;

    public RecommendationFragment() {}

    public static RecommendationFragment newInstance(String selectedGenre) {
        RecommendationFragment recommendationFragment = new RecommendationFragment();
        Bundle args = new Bundle();
        args.putString("selectedGenre", selectedGenre);
        recommendationFragment.setArguments(args);
        Log.d("selectedGenre", selectedGenre);
        return recommendationFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommendation, container, false);

        return view;
    }

}
