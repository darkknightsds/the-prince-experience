package com.darkknightsds.theprinceexperience.ui;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.darkknightsds.theprinceexperience.Constants;
import com.darkknightsds.theprinceexperience.R;
import com.darkknightsds.theprinceexperience.models.Recommendation;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecommendationFragment extends Fragment {
    @BindView(R.id.recommendationTitle) TextView mRecoTitle;
    @BindView(R.id.recommendationImage) ImageView mRecoImage;
    @BindView(R.id.albumsRecycler) RecyclerView mAlbumsRecycler;
    @BindView(R.id.playlistHeader) TextView mPlaylistHeader;
    @BindView(R.id.albumsHeader) TextView mAlbumHeader;

    private Unbinder unbinder;
    private Recommendation mRecommendation;
    private Typeface mAeromaticsFont;

    public RecommendationFragment() {}

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
        mRecommendation = Parcels.unwrap(getArguments().getParcelable("recommendation"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommendation, container, false);
        unbinder = ButterKnife.bind(this, view);

        mAeromaticsFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/aero_matics_light.ttf");
        mRecoTitle.setTypeface(mAeromaticsFont);
        mPlaylistHeader.setTypeface(mAeromaticsFont);
        mAlbumHeader.setTypeface(mAeromaticsFont);

        getActivity().findViewById(R.id.fab).setVisibility(View.GONE);

        Picasso.with(view.getContext()).load(mRecommendation.getImage()).into(mRecoImage);
        mRecoTitle.setText(mRecommendation.getGenre());
        
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
