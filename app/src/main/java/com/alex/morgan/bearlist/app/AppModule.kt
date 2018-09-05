package com.alex.morgan.bearlist.app

import com.alex.morgan.ActivityScope
import com.alex.morgan.FragmentScope
import com.alex.morgan.bearlist.BearListFragment
import com.alex.morgan.bearlist.list.BearListActivity
import com.alex.morgan.bearlist.list.BearListModule
import com.morgan.alex.beardetail.BearDetailModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BearListModule::class, BearDetailModule::class])
abstract class AppModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun constributeBearListActivity(): BearListActivity

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeBearListFragment(): BearListFragment
}
