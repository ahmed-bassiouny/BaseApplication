package com.example.baseapplication.data.interactor

import com.Akoon.akoon.model.entity.UserEntity
import com.Akoon.akoon.model.repositiry.UserRepo

class UserInteractor(var userRepo: UserRepo) {

    fun login(email: String, password: String, result: (success: Boolean, error: String) -> Unit) {

        userRepo.login(UserEntity(email, password)) {
            if (it.status) {
                // save user object in shared pref
                result(true, "")
            } else {
                result(false, it.error ?: "")
            }
        }
    }

}