package com.Akoon.akoon.helper

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(private val sharedPreferences: SharedPreferences) {

    private val USER_TOKEN = "user_token"
    private val USER_OBJ = "user_obj"


     var userToken:String
        get() = sharedPreferences[USER_TOKEN]
         set(value) {
             sharedPreferences[USER_TOKEN] = value
         }

    var userObj:String
        get() = sharedPreferences[USER_OBJ]
        set(value) {
            sharedPreferences[USER_OBJ] = value
        }


}