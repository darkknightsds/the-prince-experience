package com.darkknightsds.theprinceexperience.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Album {
    String title;
    String year;
    String image;
    String genres;

    public Album() {}

    public Album(String title, String year, String image, String genres) {
        this.title = title;

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

    public String getGenres() {
        return genres;
    }

//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public void setGenres(String genres) {
//        this.genres = genres;
//    }
}
