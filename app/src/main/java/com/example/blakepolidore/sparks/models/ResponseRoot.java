package com.example.blakepolidore.sparks.models;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class ResponseRoot {

    private String id;
    private String type;
    private String expiration;
    private Options[] options;
    private Profile[] profiles;

    public ResponseRoot(String id, String type, String expiration, Options[] options, Profile[] profiles) {
        this.id = id;
        this.type = type;
        this.expiration = expiration;
        this.options = options;
        this.profiles = profiles;
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
        return profiles;
    }
}
