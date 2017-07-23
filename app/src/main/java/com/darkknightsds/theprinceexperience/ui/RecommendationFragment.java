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

import com.darkknightsds.theprinceexperience.Constants;
import com.darkknightsds.theprinceexperience.R;
import com.darkknightsds.theprinceexperience.models.Recommendation;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecommendationFragment extends Fragment {
    @BindView(R.id.recommendationImage) ImageView mRecoImage;
    @BindView(R.id.recommendationTitle) TextView mRecoTitle;
    @BindView(R.id.albumsRecycler) RecyclerView mAlbumsRecycler;

    private Unbinder unbinder;
    private DatabaseReference mRecoRef;
    private DatabaseReference mAlbumsRef;
    private DatabaseReference rootRef;
    private FirebaseAuth mAuth;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    public RecommendationFragment() {}

    public static RecommendationFragment newInstance(String selectedGenre) {
        RecommendationFragment recommendationFragment = new RecommendationFragment();
        Bundle args = new Bundle();
        args.putString("selectedGenre", selectedGenre);
        recommendationFragment.setArguments(args);
        return recommendationFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommendation, container, false);
        unbinder = ButterKnife.bind(this, view);

        rootRef = FirebaseDatabase.getInstance().getReference();
        mRecoRef = rootRef.child(Constants.FIREBASE_CHILD_RECOS);
        mAlbumsRef = rootRef.child(Constants.FIREBASE_CHILD_ALBUMS);



        getActivity().findViewById(R.id.fab).setVisibility(View.GONE);
        
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
