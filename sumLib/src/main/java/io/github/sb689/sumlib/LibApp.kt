package io.github.sb689.sumlib

import android.app.Application
import timber.log.Timber

class LibApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.d("summationlib app called")
    }
}