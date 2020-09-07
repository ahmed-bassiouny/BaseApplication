package com.Akoon.akoon.model.api

import kotlinx.coroutines.CoroutineScope
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
abstract class BaseApiProvider {
    lateinit var coroutineScope: CoroutineScope

    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) : T {
        try {
            val response = call.invoke()
            if(response.isSuccessful){
                return response.body() as T
            }else{
                return BaseResponse<T>(false, response.code(), error = response.errorBody()?.toString() ?: "") as T
            }

        } catch (e: Exception) {
            e.printStackTrace()
            val errors = ArrayList<String?>()
            errors.add(e.localizedMessage)
            return BaseResponse<T>(false, error = e.localizedMessage) as T
        }
    }
}