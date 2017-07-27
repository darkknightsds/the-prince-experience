package com.darkknightsds.theprinceexperience.adapters;

import android.content.Context;
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

    public AlbumsViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext  = itemView.getContext();
        mAlbumImageCard = (ImageView) mView.findViewById(R.id.albumImageCard);
        mAlbumNameCard = (TextView) mView.findViewById(R.id.albumNameCard);
    }

    public void bindView(String image, String albumName) {
        Picasso.with(mView.getContext()).load(image).into(mAlbumImageCard);
        mAlbumNameCard.setText(albumName);
    }

}
