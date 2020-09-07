package com.Akoon.akoon.model.api

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("success") var status: Boolean = false,
    @SerializedName("status_code") var statusCode: Int = 0,
    @SerializedName("status_message")  var error: String?,
    @SerializedName("data") var list: T?= null
    )