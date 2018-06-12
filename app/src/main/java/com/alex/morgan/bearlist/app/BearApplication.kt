package com.alex.morgan.bearlist.app

import android.app.Application

import com.alex.morgan.bearlist.list.BearListComponent
import com.alex.morgan.bearlist.list.DaggerBearListComponent

class BearApplication : Application() {

    lateinit var appComponent: AppComponent

    val bearListComponent: BearListComponent by lazy {
        DaggerBearListComponent.builder().appComponent(appComponent).build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder().build()
    }

    companion object {

        private var instance: BearApplication? = null

        fun get(): BearApplication? {
            return instance
        }
    }
}
