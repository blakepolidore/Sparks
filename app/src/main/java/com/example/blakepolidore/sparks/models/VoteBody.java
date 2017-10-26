package com.example.blakepolidore.sparks.models;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class VoteBody {

    private int option;
    private String game_id;

    public VoteBody(int option, String gameId) {
        this.option = option;
        this.game_id = gameId;
    }
}
