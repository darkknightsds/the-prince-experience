package com.darkknightsds.theprinceexperience.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Parcel
public class Album {
    String title;
    String year;
    String image;
    String genre;

    public Album() {}

    public Album(String title, String year, String image, String genre) {
        this.title = title;

        this.year = year;
        this.image = image;
        this.genre = genre;
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

    public String getGenres() {
        return genre;
    }
}
