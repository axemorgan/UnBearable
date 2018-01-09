package com.alex.morgan.bearlist.list;

import android.util.Log;

import javax.inject.Inject;

class RubeGoldbergMachine {

    private static final String LOG_TAG = "Rube Goldberg";

    @Inject
    public RubeGoldbergMachine() {
        Log.i(LOG_TAG, "Setting it all up");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void activate() {
        Log.i(LOG_TAG, "Dropping bowling ball");
        Log.i(LOG_TAG, "Lifting see-saw");
        Log.i(LOG_TAG, "Lighting match");
        Log.i(LOG_TAG, "Boiling kettle");
        Log.i(LOG_TAG, "Spinning fan");
        Log.i(LOG_TAG, "Tipping dominoes");
        Log.i(LOG_TAG, "Filling bathtub");
        Log.i(LOG_TAG, "Done");
    }
}
