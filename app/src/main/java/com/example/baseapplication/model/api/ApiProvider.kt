package com.Akoon.akoon.model.api
import com.Akoon.akoon.model.entity.*


class ApiProvider(private var apiService: ApiService): BaseApiProvider() {


    fun login(userEntity: UserEntity,result: (res: BaseResponse<UserEntity>) -> Unit) {
        coroutineScope = Coroutines.main {
            result.invoke(apiRequest { apiService.login() })
        }
    }
}


