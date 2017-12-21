package com.alex.morgan.bearlist.list;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import com.alex.morgan.bearlist.Bear;

import java.util.Collection;

import javax.inject.Inject;

public class BearFetcher {

    interface Callback {
        void onBears(Collection<Bear> bears);

        void onError();
    }

    private final BearSource source;
    private final BearCache cache;

    @Inject
    public BearFetcher(BearSource source, BearCache cache) {
        this.source = source;
        this.cache = cache;
    }

    public void fetchBears(final Callback callback, final boolean noCache) {
        final Handler mainHandler = new Handler(Looper.getMainLooper());

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Collection<Bear> bears;
                    if (noCache) {
                        bears = fetchAndCacheBears();
                    } else {
                        bears = cache.getBears();
                        if (bears.isEmpty()) {
                            bears = fetchAndCacheBears();
                        }
                    }

                    final Collection<Bear> finalBears = bears;
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onBears(finalBears);
                        }
                    });

                } catch (Exception e) {
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onError();
                        }
                    });
                }
            }
        });
    }

    private Collection<Bear> fetchAndCacheBears() {
        Collection<Bear> bears = source.getAllBears();
        cache.putBears(bears);
        return bears;
    }
}
