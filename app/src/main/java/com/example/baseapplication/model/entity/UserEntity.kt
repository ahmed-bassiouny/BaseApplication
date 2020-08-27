package com.Akoon.akoon.model.entity

import com.google.gson.annotations.SerializedName

data class UserEntity(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
) {
    @SerializedName("name")
    var name: String = ""
    @SerializedName("id")
    var id: String = ""
    @SerializedName("deviceToken")
    var deviceToken: String = "fdsfsd"
}