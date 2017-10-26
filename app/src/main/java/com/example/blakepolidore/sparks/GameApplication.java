package com.example.blakepolidore.sparks;

import android.app.Application;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class GameApplication extends Application {

    private static GameApplication instance;
    private GameContract.Manager gameManager;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        gameManager = new GameManager();
    }

    public static GameApplication getInstance() {
        return instance;
    }

    public GameContract.Manager getGameManager() {
        return gameManager;
    }
}
