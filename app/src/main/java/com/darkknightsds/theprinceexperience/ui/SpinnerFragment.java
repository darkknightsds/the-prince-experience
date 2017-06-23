package com.darkknightsds.theprinceexperience.ui;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.darkknightsds.theprinceexperience.R;

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

    View.OnClickListener loadGenre = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((MainActivity)getActivity()).loadFragment(new RecommendationFragment());
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
