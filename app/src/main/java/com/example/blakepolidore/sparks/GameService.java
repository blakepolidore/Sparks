package com.example.blakepolidore.sparks;

import com.example.blakepolidore.sparks.models.ResponseRoot;
import com.example.blakepolidore.sparks.models.VoteBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by blakepolidore on 10/26/17.
 */

public interface GameService {

    @GET("game")
    Call<ResponseRoot> getGame();

    @POST("game")
    Call<ResponseRoot> postResults(@Body VoteBody body);
}
