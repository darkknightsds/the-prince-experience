package com.darkknightsds.theprinceexperience.ui;


import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.darkknightsds.theprinceexperience.R;
import com.darkknightsds.theprinceexperience.models.Recommendation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendationFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.recommendationImage) ImageView mRecoImage;
    @BindView(R.id.spotifyLogo) ImageView mSpotifyLogo;
    @BindView(R.id.recommendationTitle) TextView mRecoTitle;
    @BindView(R.id.albumsRecycler) RecyclerView mAlbumsRecycler;

    private Recommendation mRecommendation;
    private DatabaseReference mRecoRef;

    public RecommendationFragment() {
    }

    public static RecommendationFragment newInstance(Recommendation recommendation) {
        RecommendationFragment recommendationFragment = new RecommendationFragment();
        Bundle args = new Bundle();
        args.putParcelable("recommendation", Parcels.wrap(recommendation));
        recommendationFragment.setArguments(args);
        return recommendationFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecommendation = Parcels.unwrap(getArguments().getParcelable("album"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommendation, container, false);
        ButterKnife.bind(this, view);

        mRecoRef = FirebaseDatabase
                .getInstance()
                .getReference("recommendations");

        Picasso.with(view.getContext()).load(mRecommendation.getImage()).into(mRecoImage);

        mRecoTitle.setText(mRecommendation.getGenre());
        mSpotifyLogo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSpotifyLogo) {
            Intent spotifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mRecommendation.getPlaylistUri()));
            startActivity(spotifyIntent);
        }
    }

}
