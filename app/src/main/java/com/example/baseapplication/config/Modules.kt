package com.Akoon.akoon.config

import android.app.Application
import android.content.Context
import com.Akoon.akoon.helper.PreferenceHelper
import com.Akoon.akoon.model.api.*
import com.Akoon.akoon.model.repositiry.*
import com.example.baseapplication.model.interactor.UserInteractor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {
    single { AuthInterceptor(get()) }
    single { RetroClient.provideOkHttpClient(get()) }
    single { RetroClient.provideRetrofit(get()) }
    single { ApiProvider(get()) }
    single { ApiService.createAuthService(get()) }
}

val repoModule = module {
    single { UserRepo(get(),get()) }
}

val interactorModule = module {
    single { UserInteractor(get()) }
}


val preferencesModule = module {
    single { androidContext().getSharedPreferences("Akoon", Context.MODE_PRIVATE) }
    single {
        PreferenceHelper(get())
    }
}


