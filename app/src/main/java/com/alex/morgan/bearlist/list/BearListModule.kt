package com.alex.morgan.bearlist.list

import dagger.Binds
import dagger.Module

@Module(includes = [BearDataModule::class])
internal abstract class BearListModule {
    @Binds
    abstract fun bindBearListPresenter(presenter: BearListPresenter): BearListContract.Presenter
}
