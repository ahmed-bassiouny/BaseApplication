package com.Akoon.akoon.model.api

import com.Akoon.akoon.model.entity.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.*

interface ApiService {

    companion object {
        fun createAuthService(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }

    }


    @GET("cities")
     suspend fun login(): Response<BaseResponse<UserEntity>>


}