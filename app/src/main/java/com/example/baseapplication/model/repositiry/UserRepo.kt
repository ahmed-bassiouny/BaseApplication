package com.Akoon.akoon.model.repositiry

import com.Akoon.akoon.helper.PreferenceHelper
import com.Akoon.akoon.model.api.ApiProvider
import com.Akoon.akoon.model.api.BaseResponse
import com.Akoon.akoon.model.entity.UserEntity
import com.google.gson.Gson

class UserRepo(private var apiProvider: ApiProvider, var pref: PreferenceHelper) {

    fun login(userEntity: UserEntity,result:(res:BaseResponse<UserEntity>) -> Unit) {
       apiProvider.login(userEntity,result)
    }

    fun getUserToken():String{
        return pref.userToken
    }
}