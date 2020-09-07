package com.Akoon.akoon.model.repositiry

import com.Akoon.akoon.helper.PreferenceHelper
import com.Akoon.akoon.model.api.ApiProvider
import com.Akoon.akoon.model.api.BaseResponse
import com.Akoon.akoon.model.entity.CityEntity
import com.Akoon.akoon.model.entity.UserEntity
import com.google.gson.Gson

class CityRepo(private var apiProvider: ApiProvider) {

    fun getCities(result:(res:BaseResponse<List<CityEntity>>) -> Unit) {
       apiProvider.getCities(result)
    }

}