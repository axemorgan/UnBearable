package com.alex.morgan.bearlist.list

import dagger.Binds
import dagger.Module
import dagger.Provides
import java.util.*

@Module
abstract class BearDataModule {
    @Binds
    abstract fun bindBearSource(source: RandomBearGenerator): BearSource

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideRandom(): Random {
            return Random()
        }
    }
}