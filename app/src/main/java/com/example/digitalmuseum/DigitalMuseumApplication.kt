package com.example.digitalmuseum

import android.app.Application
import android.content.Context
import com.example.digitalmuseum.di.apiModule
import com.example.digitalmuseum.di.remoteRepositoryModule
import com.example.digitalmuseum.di.retrofitModule
import com.example.digitalmuseum.di.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DigitalMuseumApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@DigitalMuseumApplication)
            modules(listOf(
                apiModule, retrofitModule, remoteRepositoryModule, viewModelModule
            ))
        }
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}