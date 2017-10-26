package com.example.blakepolidore.sparks;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class GameApplication extends Application {

    private static GameApplication instance;
    private GameContract.Manager gameManager;
    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        sharedPreferences = getSharedPreferences("Game" ,Context.MODE_PRIVATE);
        gameManager = new GameManager();
    }

    public static GameApplication getInstance() {
        return instance;
    }

    public GameContract.Manager getGameManager() {
        return gameManager;
    }

    public void saveToSharedPreferences(String key, String value) {
        sharedPreferences.edit().putString(key, value).commit();
    }

    public String getStringFromSharedPrefs(String key) {
        return sharedPreferences.getString(key, null);
    }
}
