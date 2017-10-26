package com.example.blakepolidore.sparks.models;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class Options {

    private String imageUrl;
    private String text1, text2, text3;
    private String id;
    private String numOfVotes;

    public Options(String imageUrl, String text1, String text2, String text3, String id, String numOfVotes) {
        this.imageUrl = imageUrl;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.id = id;
        this.numOfVotes = numOfVotes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(String numOfVotes) {
        this.numOfVotes = numOfVotes;
    }
}
