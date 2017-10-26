package com.example.blakepolidore.sparks.models;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class Profile {

    private String imageUrl;
    private String description;

    public Profile(String imageUrl, String description) {
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
