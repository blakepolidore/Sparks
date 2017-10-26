package com.example.blakepolidore.sparks;

import android.content.Context;
import android.content.SharedPreferences;

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
    private final static String TAG = "GameManager";

    private Retrofit retrofit;
    private Context context;
    private SharedPreferences sharedPreferences;

    public GameManager(Context context) {
        this.context = context;

        retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .baseUrl("http://sparks-cmb.herokuapp.com/")
                    .build();

        sharedPreferences = context.getSharedPreferences(GAME_ID, Context.MODE_PRIVATE);
    }

    @Override
    public void retrieveData(final DataRetrievalCallback callback) {
        retrofit.create(GameService.class).getGame()
                .enqueue(new Callback<ResponseRoot>() {
                    @Override
                    public void onResponse(Call<ResponseRoot> call, Response<ResponseRoot> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Result result = response.body().getResult();
                            sharedPreferences.edit().putString(GAME_ID, result.getGameId()).commit();

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
    public void optionChosen(String answerId, final OptionChosenCallback callback) {
        VoteBody body = new VoteBody(answerId, sharedPreferences.getString(GAME_ID, null
        ));
        retrofit.create(GameService.class).postResults(body)
                .enqueue(new Callback<ResponseRoot>() {
                    @Override
                    public void onResponse(Call<ResponseRoot> call, Response<ResponseRoot> response) {
                        if (response.isSuccessful()) {
                            callback.onSuccess();
                        } else {
                            callback.onFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseRoot> call, Throwable t) {
                        callback.onFailure();
                    }
                });
    }
}
