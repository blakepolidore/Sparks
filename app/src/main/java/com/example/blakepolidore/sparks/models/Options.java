package com.example.blakepolidore.sparks.models;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class Options {

    private String imageUrl;
    private String description;
    private String id;
    private int numOfVotes;

    public Options(String imageUrl, String description, String id, int numOfVotes) {
        this.imageUrl = imageUrl;
        this.description = description;
        this.id = id;
        this.numOfVotes = numOfVotes;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(int numOfVotes) {
        this.numOfVotes = numOfVotes;
    }
}
