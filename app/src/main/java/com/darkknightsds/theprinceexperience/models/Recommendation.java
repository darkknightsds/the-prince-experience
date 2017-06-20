package com.darkknightsds.theprinceexperience.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Recommendation {
    String genre;
    String playlistUrl;
    List<String> albums = new ArrayList<>();
    String image;

    public Recommendation() {}

    public Recommendation(String genre, String playlistUrl, List<String> albums, String image) {
        this.genre = genre;
        this.playlistUrl = playlistUrl;
        this.albums = albums;
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlaylistUrl() {
        return playlistUrl;
    }

    public List<String> getAlbums() {
        return albums;
    }

    public String getImage() {
        return image;
    }


}
