package com.example.blakepolidore.sparks.models;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class Options {

    private String img_url;
    private String description;
    private String option_id;
    private int num_of_votes;

    public Options(String imageUrl, String description, String id, int numOfVotes) {
        this.img_url = imageUrl;
        this.description = description;
        this.option_id = id;
        this.num_of_votes = numOfVotes;
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

    public String getOptionId() {
        return option_id;
    }

    public void setOptionId(String id) {
        this.option_id = id;
    }

    public int getNumOfVotes() {
        return num_of_votes;
    }

    public void setNumOfVotes(int numOfVotes) {
        this.num_of_votes = numOfVotes;
    }
}
