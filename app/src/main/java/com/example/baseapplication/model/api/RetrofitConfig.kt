package com.Akoon.akoon.model.api

import com.Akoon.akoon.helper.PreferenceHelper
import com.Akoon.akoon.model.repositiry.UserRepo
import com.example.baseapplication.model.interactor.UserInteractor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


private const val READ_TIME_OUT_CONNECTION = 1
private const val WRITE_TIME_OUT_CONNECTION = 1
private const val TIME_OUT_CONNECTION = 1
private val TINE_UNIT_FOR_CONNECTION = TimeUnit.MINUTES

object RetroClient {
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {

        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level =
                if (true) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
        return OkHttpClient.Builder()
            .readTimeout(READ_TIME_OUT_CONNECTION.toLong(), TINE_UNIT_FOR_CONNECTION)
            .writeTimeout(WRITE_TIME_OUT_CONNECTION.toLong(), TINE_UNIT_FOR_CONNECTION)
            .connectTimeout(TIME_OUT_CONNECTION.toLong(), TINE_UNIT_FOR_CONNECTION)
            .addInterceptor(authInterceptor)
            .addInterceptor(httpLoggingInterceptor).build()
    }
}

class AuthInterceptor(var userRepo: UserRepo) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        // DONT INCLUDE API KEYS IN YOUR SOURCE CODE
        val url = req.url.newBuilder()
            .addQueryParameter("token",userRepo.getUserToken())
            .build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}

