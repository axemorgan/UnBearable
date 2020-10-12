package com.morgan.alex.beardetail

import com.alex.morgan.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BearDetailModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [BearDetailPresenterModule::class])
    abstract fun contributeBearDetailFragment(): BearDetailFragment
}