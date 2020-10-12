package com.alex.morgan.bearlist.list

import com.alex.morgan.FragmentScope
import dagger.Binds
import dagger.Module

@Module(includes = [BearDataModule::class])
internal abstract class BearListModule {
    @Binds
    @FragmentScope
    abstract fun bindBearListPresenter(presenter: BearListPresenter): BearListContract.Presenter
}
