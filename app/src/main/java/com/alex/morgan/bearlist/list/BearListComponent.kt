package com.alex.morgan.bearlist.list

import com.alex.morgan.bearlist.BearListFragment
import com.alex.morgan.bearlist.app.ActivityScope
import com.alex.morgan.bearlist.app.AppComponent

import javax.inject.Singleton

import dagger.Component

@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(BearListModule::class)])
interface BearListComponent {
    fun inject(activity: BearListActivity)

    fun inject(fragment: BearListFragment)
}
