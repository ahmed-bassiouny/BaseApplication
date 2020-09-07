package com.Akoon.akoon.config

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

import org.koin.android.ext.koin.androidLogger

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(
                listOf(
                    preferencesModule,
                    networkModule,
                    repoModule,
                    interactorModule
                )
            )

        }

    }
}