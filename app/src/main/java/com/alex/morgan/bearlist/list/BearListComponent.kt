package com.alex.morgan.bearlist.list

import com.alex.morgan.bearlist.app.AppComponent

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(BearListModule::class))
interface BearListComponent {
    fun inject(activity: BearListActivity)
}
