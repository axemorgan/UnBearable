package com.alex.morgan.bearlist.app

import com.alex.morgan.ActivityScope
import com.alex.morgan.FragmentScope
import com.alex.morgan.bearlist.BearListFragment
import com.alex.morgan.bearlist.list.BearListActivity
import com.alex.morgan.bearlist.list.BearListModule
import com.morgan.alex.beardetail.BearDetailModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [BearListActivityModule::class])
    fun contributeBearListActivity(): BearListActivity
}

@Module
interface BearListActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [BearListModule::class])
    fun contributeBearListFragment(): BearListFragment
}
