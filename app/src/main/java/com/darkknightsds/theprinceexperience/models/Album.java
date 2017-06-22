package com.darkknightsds.theprinceexperience.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Album {
    String title;
    String year;
    String image;
    ArrayList<String> genres = new ArrayList<>();

    public Album() {}

    public Album(String genre, String year, String image, ArrayList<String> genres) {
        this.title = genre;
        this.year = year;
        this.image = image;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }
}
