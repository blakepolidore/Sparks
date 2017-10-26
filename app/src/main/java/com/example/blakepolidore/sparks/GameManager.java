package com.example.blakepolidore.sparks;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class GameManager implements GameContract.Manager {

    private Retrofit retrofit;

    public GameManager() {

        retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .baseUrl("url")
                    .build();
    }

    @Override
    public void retrieveData(DataRetrievalCallback callback) {

    }

    @Override
    public void optionChosen(String id, OptionChosenCallback callback) {

    }
}
