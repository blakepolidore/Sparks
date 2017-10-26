package com.example.blakepolidore.sparks.models;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class Profile {

    private String img_url;
    private String description;
    private String profile_id;

    public Profile(String imageUrl, String description, String profile_id) {
        this.img_url = imageUrl;
        this.description = description;
        this.profile_id = profile_id;
    }

    public String getImageUrl() {
        return img_url;
    }

    public void setImageUrl(String imageUrl) {
        this.img_url = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }
}
