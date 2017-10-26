package com.example.blakepolidore.sparks;

import com.example.blakepolidore.sparks.models.Options;
import com.example.blakepolidore.sparks.models.Profile;
import com.example.blakepolidore.sparks.models.Result;

import java.util.ArrayList;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class GamePresenter implements GameContract.Presenter, GameContract.Presenter.TimerListener {

    private GameContract.View view;
    private GameContract.Manager manager;

    public GamePresenter(GameContract.View view, GameContract.Manager manager) {
        this.view = view;
        this.manager = manager;
    }

    @Override
    public void start() {
        manager.setTimerListener(this);
        retrieveData();
    }

    @Override
    public void stop() {

    }

    @Override
    public void optionChosen(String answerId) {
        manager.optionChosen(answerId, new GameContract.Manager.OptionChosenCallback() {
            @Override
            public void onSuccess() {
                view.showVoteSuccessful();
            }

            @Override
            public void onFailure() {
                view.showVoteFailure();
            }
        });
    }

    @Override
    public void onTimerTick(long millisToFinish) {
        view.showTimeRemaining(millisToFinish);
    }

    @Override
    public void onTimerFinished() {
        retrieveData();
        view.clearData();
    }

    private void retrieveData() {
        manager.retrieveData(new GameContract.Manager.DataRetrievalCallback() {
            @Override
            public void onDataRetrieved(ArrayList<Options> options, ArrayList<Profile> profiles, String type) {
                view.showOptions(options);
                if (type.equals(Result.ICEBREAKER)) {
                    view.showProfiles(profiles);
                }
            }

            @Override
            public void onRetrievalFailed() {
                view.showNoData();
            }
        });
    }
}
