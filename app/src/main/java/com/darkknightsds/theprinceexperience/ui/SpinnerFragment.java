package com.darkknightsds.theprinceexperience.ui;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.darkknightsds.theprinceexperience.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SpinnerFragment extends Fragment {
    @BindView(R.id.genres_spinner) Spinner mGenresSpinner;
    @BindView(R.id.spinnerHeader) TextView mSpinnerHeader;
    @BindView(R.id.spinnerSub) TextView mSpinnerSub;

    private Unbinder unbinder;

    public SpinnerFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spinner, container, false);
        getActivity().findViewById(R.id.fab).setVisibility(View.GONE);
        unbinder = ButterKnife.bind(this, view);

        Typeface aeromaticsFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/aero_matics_light.ttf");
        mSpinnerHeader.setTypeface(aeromaticsFont);
        mSpinnerSub.setTypeface(aeromaticsFont);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.genres_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGenresSpinner.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        getActivity().findViewById(R.id.fab).setVisibility(View.VISIBLE);
    }
}
