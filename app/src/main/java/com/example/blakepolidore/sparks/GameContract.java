package com.example.blakepolidore.sparks;

import com.example.blakepolidore.sparks.models.Options;
import com.example.blakepolidore.sparks.models.Profile;

import java.util.ArrayList;

/**
 * Created by blakepolidore on 10/26/17.
 */

public interface GameContract {

    interface View {
        void showOptions(ArrayList<Options> options);
        void showProfiles(ArrayList<Profile> profiles);
        void showNoData();

        void showVoteSuccessful();
        void showVoteFailure();
    }

    interface Presenter {
        void start();
        void stop();

        void optionChosen(String id);
    }

    interface Manager {
        void retrieveData(DataRetrievalCallback callback);

        void optionChosen(String id, OptionChosenCallback callback);

        interface DataRetrievalCallback {
            void onDataRetrieved(ArrayList<Options> options, ArrayList<Profile> profiles);
            void onRetrievalFailed();
        }

        interface OptionChosenCallback {
            void onSuccess();
            void onFailure();
        }
    }

    interface AdapterListener {
        void onOptionChosen(String id);
    }
}
