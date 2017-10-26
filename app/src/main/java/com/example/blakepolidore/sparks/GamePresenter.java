package com.example.blakepolidore.sparks;

import com.example.blakepolidore.sparks.models.Options;
import com.example.blakepolidore.sparks.models.Profile;

import java.util.ArrayList;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class GamePresenter implements GameContract.Presenter {

    private GameContract.View view;
    private GameContract.Manager manager;

    public GamePresenter(GameContract.View view, GameContract.Manager manager) {
        this.view = view;
        this.manager = manager;
    }

    @Override
    public void start() {
        manager.retrieveData(new GameContract.Manager.DataRetrievalCallback() {
            @Override
            public void onDataRetrieved(ArrayList<Options> options, ArrayList<Profile> profiles) {
                view.showOptions(options);
                view.showProfiles(profiles);
            }

            @Override
            public void onRetrievalFailed() {
                view.showNoData();
            }
        });
    }

    @Override
    public void stop() {

    }

    @Override
    public void optionChosen(String id) {
        manager.optionChosen(id, new GameContract.Manager.OptionChosenCallback() {
            @Override
            public void onSuccess() {
                
            }

            @Override
            public void onFailure() {

            }
        });
    }
}
