package com.darkknightsds.theprinceexperience.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.darkknightsds.theprinceexperience.models.Album;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class FirebaseAlbumsAdapter  {
    private DatabaseReference mRef;
    private Context mContext;
    private ArrayList<Album> mAlbums = new ArrayList<>();
    private FirebaseAlbumsViewHolder mViewHolder;


}
