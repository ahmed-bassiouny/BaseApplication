package com.example.baseapplication.model.interactor

import com.Akoon.akoon.helper.PreferenceHelper
import com.Akoon.akoon.model.api.BaseResponse
import com.Akoon.akoon.model.entity.CityEntity
import com.Akoon.akoon.model.entity.UserEntity
import com.Akoon.akoon.model.repositiry.CityRepo
import com.Akoon.akoon.model.repositiry.UserRepo

class CityInteractor(var repo: CityRepo) {

    fun getCities(list: (list: List<CityEntity>) -> Unit,msg: (error: String) -> Unit) {

        repo.getCities {
            if (it.status) {
                // save list in shared pref
                list(it.list ?: ArrayList())
            } else {
                msg(it.error ?: "")
            }
        }
    }

}