package com.alex.morgan.bearlist.app

import android.app.Activity
import android.app.Application
import android.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

class BearApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        instance = this
        DaggerAppComponent.builder()
            .bindContext(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    companion object {

        private lateinit var instance: BearApplication

        fun get(): BearApplication {
            return instance
        }
    }
}
