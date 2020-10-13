package com.alex.morgan.bearlist.app

import com.alex.morgan.ActivityScope
import com.alex.morgan.FragmentScope
import com.alex.morgan.bearlist.BearListFragment
import com.alex.morgan.bearlist.list.BearListActivity
import com.alex.morgan.bearlist.list.BearListModule
import com.morgan.alex.beardetail.BearDetailModule
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.DispatchingAndroidInjector

@Module(includes = [BearDetailModule::class])
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [BearListActivityModule::class])
    fun contributeBearListActivity(): BearListActivity

    @Binds
    fun bindAndroidInjector(injector: DispatchingAndroidInjector<Any>): AndroidInjector<Any>
}

@Module
interface BearListActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [BearListModule::class])
    fun contributeBearListFragment(): BearListFragment
}
