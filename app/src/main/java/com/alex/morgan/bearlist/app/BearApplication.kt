package com.alex.morgan.bearlist.app

import android.app.Application
import dagger.android.*
import javax.inject.Inject

class BearApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        instance = this
        DaggerAppComponent.builder()
            .bindContext(this)
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector


    companion object {

        private lateinit var instance: BearApplication
        fun get(): BearApplication {
            return instance
        }
    }
}
