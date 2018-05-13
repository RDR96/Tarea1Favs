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

    public Planet (String name, String description, ImageView image) {
        this.name = name;
        this.description = description;
        this.image = image;
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
