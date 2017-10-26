package com.example.blakepolidore.sparks.models;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class Result {

    public static final String ICEBREAKER = "icebreaker";
    public static final String MATCHMAKER = "matchmaker";

    private String id;
    private String type;
    private String expiration;
    private Options[] options;
    private Profile[] profile;

    public Result(String id, String type, String expiration, Options[] options, Profile[] profiles) {
        this.id = id;
        this.type = type;
        this.expiration = expiration;
        this.options = options;
        this.profile = profiles;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }

    public Options[] getOptions() {
        return options;
    }

    public Profile[] getProfiles() {
        return profile;
    }
}
