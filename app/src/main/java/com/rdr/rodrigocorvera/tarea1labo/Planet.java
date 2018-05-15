package com.rdr.rodrigocorvera.tarea1labo;

import android.annotation.SuppressLint;
import android.widget.ImageView;

/**
 * Created by Rodrigo Corvera on 13/5/2018.
 */

public class Planet {

    String name;
    String description;
    ImageView image;
    int originalPosition;
    int favPos;
    boolean favorite;

    public Planet (String name, String description, ImageView image, boolean favorite, int originalPos) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.favorite = favorite;
        this.originalPosition = originalPos;
    }

    public int getOriginalPosition() {
        return originalPosition;
    }

    public void setOriginalPosition(int originalPosition) {
        this.originalPosition = originalPosition;
    }

    public Planet (String name, String description, ImageView image, boolean favorite, int originalPos, int favPos) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.favorite = favorite;
        this.originalPosition = originalPos;
        this.favPos = favPos;
    }

    public int getFavPos() {
        return favPos;
    }

    public void setFavPos(int favPos) {
        this.favPos = favPos;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image.getId();
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
