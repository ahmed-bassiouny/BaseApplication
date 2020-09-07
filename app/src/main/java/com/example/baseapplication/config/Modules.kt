package com.Akoon.akoon.config

import android.content.Context
import com.Akoon.akoon.helper.PreferenceHelper
import com.Akoon.akoon.model.api.*
import com.Akoon.akoon.model.repositiry.*
import com.example.baseapplication.data.interactor.CityInteractor
import com.example.baseapplication.data.interactor.UserInteractor
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
    single { CityRepo(get()) }
}

val interactorModule = module {
    single { UserInteractor(get()) }
    single { CityInteractor(get()) }
}


val preferencesModule = module {
    single { androidContext().getSharedPreferences("Akoon", Context.MODE_PRIVATE) }
    single {
        PreferenceHelper(get())
    }
}


