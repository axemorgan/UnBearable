package com.alex.morgan.bearlist.list

import java.util.Random

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
internal abstract class BearListModule {
    @Binds
    abstract fun bindBearListPresenter(presenter: BearListPresenter): BearListContract.Presenter

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideRandom(): Random {
            return Random()
        }
    }
}
