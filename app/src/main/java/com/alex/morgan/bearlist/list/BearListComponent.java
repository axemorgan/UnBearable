package com.alex.morgan.bearlist.list;

import com.alex.morgan.bearlist.app.AppComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = AppComponent.class, modules = BearListModule.class)
public interface BearListComponent {
    void inject(BearListActivity activity);
}
