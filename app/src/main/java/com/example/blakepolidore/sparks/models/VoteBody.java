package com.example.blakepolidore.sparks.models;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class VoteBody {

    private String answerId;
    private String questionId;

    public VoteBody(String answerId, String questionId) {
        this.answerId = answerId;
        this.questionId = questionId;
    }
}
