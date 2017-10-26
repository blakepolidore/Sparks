package com.example.blakepolidore.sparks;

import com.example.blakepolidore.sparks.models.Options;
import com.example.blakepolidore.sparks.models.Profile;
import com.example.blakepolidore.sparks.models.ResponseRoot;
import com.example.blakepolidore.sparks.models.Result;
import com.example.blakepolidore.sparks.models.VoteBody;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class GameManager implements GameContract.Manager {

    private final static String GAME_ID = "gameId";

    private Retrofit retrofit;

    public GameManager() {

        retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .baseUrl("url")
                    .build();
    }

    @Override
    public void retrieveData(final DataRetrievalCallback callback) {
        retrofit.create(GameService.class).getGame()
                .enqueue(new Callback<ResponseRoot>() {
                    @Override
                    public void onResponse(Call<ResponseRoot> call, Response<ResponseRoot> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Result result = response.body().getResult();
                            GameApplication.getInstance().saveToSharedPreferences(GAME_ID, result.getId());

                            ArrayList<Options> options = new ArrayList<Options>();
                            for (Options option : result.getOptions()) {
                                options.add(option);
                            }

                            ArrayList<Profile> profiles = new ArrayList<Profile>();
                            for (Profile profile : result.getProfiles()) {
                                profiles.add(profile);
                            }

                            callback.onDataRetrieved(options, profiles, result.getType());
                        } else {
                            callback.onRetrievalFailed();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseRoot> call, Throwable t) {
                        callback.onRetrievalFailed();
                    }
                });
    }

    @Override
    public void optionChosen(String answerId, OptionChosenCallback callback) {
        VoteBody body = new VoteBody(answerId, GameApplication.getInstance().getStringFromSharedPrefs(GAME_ID));
        retrofit.create(GameService.class).postResults(body)
                .enqueue(new Callback<ResponseRoot>() {
                    @Override
                    public void onResponse(Call<ResponseRoot> call, Response<ResponseRoot> response) {

                    }

                    @Override
                    public void onFailure(Call<ResponseRoot> call, Throwable t) {

                    }
                });
    }
}
