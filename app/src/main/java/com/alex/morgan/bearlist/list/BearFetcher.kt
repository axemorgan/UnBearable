package com.alex.morgan.bearlist.list

import android.os.AsyncTask
import android.os.Handler
import android.os.Looper

import com.alex.morgan.bearlist.Bear

import javax.inject.Inject

class BearFetcher @Inject
constructor(private val source: BearSource, private val cache: BearCache) {

    interface Callback {
        fun onBears(bears: Collection<Bear>)

        fun onError()
    }

    fun fetchBears(callback: Callback, noCache: Boolean) {
        val mainHandler = Handler(Looper.getMainLooper())

        AsyncTask.execute {
            try {
                var bears: Collection<Bear>
                if (noCache) {
                    bears = fetchAndCacheBears()
                } else {
                    bears = cache.bears
                    if (bears.isEmpty()) {
                        bears = fetchAndCacheBears()
                    }
                }

                mainHandler.post { callback.onBears(bears) }

            } catch (e: Exception) {
                mainHandler.post { callback.onError() }
            }
        }
    }

    private fun fetchAndCacheBears(): Collection<Bear> {
        val bears = source.allBears
        cache.putBears(bears)
        return bears
    }
}
