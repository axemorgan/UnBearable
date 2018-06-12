package com.alex.morgan.bearlist.list

import android.util.Log

import javax.inject.Inject

internal class RubeGoldbergMachine @Inject
constructor() {

    init {
        Log.i(LOG_TAG, "Setting it all up")
    }

    fun activate() {
        Log.i(LOG_TAG, "Dropping bowling ball")
        Log.i(LOG_TAG, "Lifting see-saw")
        Log.i(LOG_TAG, "Lighting match")
        Log.i(LOG_TAG, "Boiling kettle")
        Log.i(LOG_TAG, "Spinning fan")
        Log.i(LOG_TAG, "Tipping dominoes")
        Log.i(LOG_TAG, "Filling bathtub")
        Log.i(LOG_TAG, "Done")
    }

    companion object {

        private const val LOG_TAG = "Rube Goldberg"
    }
}
