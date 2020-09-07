package com.example.baseapplication.data.interactor

import com.Akoon.akoon.model.entity.CityEntity
import com.Akoon.akoon.model.repositiry.CityRepo

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