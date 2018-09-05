package com.alex.morgan.bearlist.list

import dagger.Binds
import dagger.Module

@Module
abstract class BearDataModule {
    @Binds
    abstract fun bindBearSource(source: RandomBearGenerator): BearSource
}