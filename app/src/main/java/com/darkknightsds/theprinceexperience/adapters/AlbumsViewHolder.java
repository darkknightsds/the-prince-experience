package com.darkknightsds.theprinceexperience.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.darkknightsds.theprinceexperience.R;
import com.squareup.picasso.Picasso;

public class AlbumsViewHolder extends RecyclerView.ViewHolder {
    View mView;
    Context mContext;

    private ImageView mAlbumImageCard;
    private TextView mAlbumNameCard;
    private TextView mAlbumDateCard;
    private Typeface mAeromaticsFont;
    private String mWikipedia;

    public AlbumsViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext  = itemView.getContext();
        mAlbumImageCard = (ImageView) mView.findViewById(R.id.albumImageCard);
        mAlbumNameCard = (TextView) mView.findViewById(R.id.albumNameCard);
        mAlbumDateCard = (TextView) mView.findViewById(R.id.albumDateCard);
        mAeromaticsFont = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/aero_matics_light.ttf");
        mAlbumDateCard.setTypeface(mAeromaticsFont);
        mAlbumNameCard.setTypeface(mAeromaticsFont);
    }

    public void bindView(String image, String albumName, String albumDate, String wikipedia) {
        Picasso.with(mView.getContext()).load(image).into(mAlbumImageCard);
        mAlbumNameCard.setText(albumName);
        mAlbumDateCard.setText(albumDate);
        mWikipedia = wikipedia;
        mAlbumImageCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent wikiIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mWikipedia));
                mContext.startActivity(wikiIntent);
            }
        });
    }
}