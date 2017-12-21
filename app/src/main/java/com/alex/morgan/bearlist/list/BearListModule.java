package com.alex.morgan.bearlist.list;

import java.util.Random;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
abstract class BearListModule {
    @Binds
    abstract BearListContract.Presenter bindBearListPresenter(BearListPresenter presenter);

    @Binds
    abstract BearSource bindBearSource(StaticBearSource source);

    @Provides
    static Random provideRandom() {
        return new Random();
    }
}
