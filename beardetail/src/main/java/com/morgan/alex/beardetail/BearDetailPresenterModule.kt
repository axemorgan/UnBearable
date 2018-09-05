package com.morgan.alex.beardetail

import dagger.Binds
import dagger.Module

@Module
abstract class BearDetailPresenterModule {
    @Binds
    abstract fun bindPresenter(presenter: BearDetailPresenter): BearDetailContract.Presenter
}