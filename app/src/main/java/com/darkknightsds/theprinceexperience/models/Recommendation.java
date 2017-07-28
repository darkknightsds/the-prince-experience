package com.darkknightsds.theprinceexperience.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Recommendation {
    String genre;
    String playlistUri;
    String image;
    String description;

    public Recommendation() {}

    public Recommendation(String genre, String playlistUri, String image, String description) {
        this.genre = genre;
        this.playlistUri = playlistUri;
        this.image = image;
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlaylistUri() {
        return playlistUri;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
