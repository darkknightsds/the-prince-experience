package com.darkknightsds.theprinceexperience.ui;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.darkknightsds.theprinceexperience.Constants;
import com.darkknightsds.theprinceexperience.R;
import com.darkknightsds.theprinceexperience.models.Album;
import com.darkknightsds.theprinceexperience.models.Recommendation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pl.bclogic.pulsator4droid.library.PulsatorLayout;

public class SpinnerFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.genres_spinner) Spinner mGenresSpinner;
    @BindView(R.id.spinnerHeader) TextView mSpinnerHeader;
    @BindView(R.id.spinnerSub) TextView mSpinnerSub;
    @BindView(R.id.symbolButton) ImageButton mSymbolButton;
    @BindView(R.id.pulsator) PulsatorLayout mPulsator;
    @BindView(R.id.loveSymbol) ImageView mLoveSymbol;

    private Unbinder unbinder;
    private String mSelectedGenre;
    private Typeface mAeromaticsFont;
    private RecommendationFragment mRecommendationFragment;
    private Query mRecoQuery;
    private Query mAlbumQuery;
    private DatabaseReference rootRef;
    private String mGenre;
    private String mImage;
    private String mUri;
    private String mTitle;
    private String mYear;
    private String mGenres;
    private String mAlbumCover;
    private Recommendation mRecommmendation;
    private Album mAlbum;
    private ArrayList<Album> mAlbums;

    View.OnClickListener loadGenre = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mRecommendationFragment = new RecommendationFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("selectedGenre", Parcels.wrap(mRecommmendation));
            mRecommendationFragment.setArguments(bundle);
            ((MainActivity)getActivity()).loadFragment(RecommendationFragment.newInstance(mRecommmendation));
        }
    };

    public SpinnerFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spinner, container, false);
        getActivity().findViewById(R.id.fab).setVisibility(View.GONE);
        unbinder = ButterKnife.bind(this, view);

        mAeromaticsFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/aero_matics_light.ttf");
        mSpinnerHeader.setTypeface(mAeromaticsFont);
        mSpinnerSub.setTypeface(mAeromaticsFont);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.genres_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGenresSpinner.setAdapter(adapter);
        mGenresSpinner.setOnItemSelectedListener(this);

        mSymbolButton.setOnClickListener(loadGenre);
        mSymbolButton.setVisibility(View.GONE);
        mPulsator.setVisibility(View.GONE);

        return view;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        if (pos !=0) {
            mSelectedGenre = parent.getItemAtPosition(pos).toString();
            rootRef = FirebaseDatabase.getInstance().getReference();
            mRecoQuery = rootRef.child(Constants.FIREBASE_CHILD_RECOS).orderByChild("genre").equalTo(mSelectedGenre);
            mRecoQuery.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot reco : dataSnapshot.getChildren()) {
                        mGenre = reco.child("genre").getValue().toString();
                        mImage = reco.child("image").getValue().toString();
                        mUri = reco.child("playlistUri").getValue().toString();
                        mRecommmendation = new Recommendation(mGenre, mUri, mImage);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            mAlbumQuery = rootRef.child(Constants.FIREBASE_CHILD_ALBUMS).orderByChild("genres");
            mAlbumQuery.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot reco : dataSnapshot.getChildren()) {
                        if (reco.getValue().toString().contains(mSelectedGenre)) {
                            Log.d("is this correct", reco.getValue().toString());
//                            mTitle = reco.child("title").getValue().toString();
//                            mYear = reco.child("year").getValue().toString();
//                            mGenres = reco.child("genres").getValue().toString();
//                            mAlbumCover = reco.child("image").getValue().toString();
//                            reco.getValue() = new Album(mTitle, mYear, mAlbumCover, mGenres);
//                            mAlbums.add(mAlbum);
//                            Log.d("list of albums", mAlbums.toString());
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            mLoveSymbol.setVisibility(View.GONE);
            mSymbolButton.setVisibility(View.VISIBLE);
            mPulsator.setVisibility(View.VISIBLE);
            mPulsator.start();
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        getActivity().findViewById(R.id.fab).setVisibility(View.VISIBLE);
    }
}
