package com.alex.morgan.bearlist.list;

import java.util.Random;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
class BearListModule {

    @Provides
    @Singleton
    BearListContract.Presenter provide(BearFetcher fetcher) {
        return new BearListPresenter(fetcher);
    }

    @Provides
    @Singleton
    BearFetcher provideBearFetcher(BearSource source, BearCache cache) {
        return new BearFetcher(source, cache);
    }

    @Provides
    @Singleton
    BearCache provideBearCache() {
        return new BearCache();
    }

    @Provides
    BearSource provideBearSource(BearNameGenerator nameGenerator) {
        return new RandomBearGenerator(nameGenerator);
    }

    @Provides
    BearNameGenerator provideBearNameGenerator(Random random) {
        return new BearNameGenerator(random);
    }

    @Provides
    Random provideRandom() {
        return new Random();
    }
}
