package com.gads.crowdfunding.network.auth

import com.gads.crowdfunding.domain.ApiCallback
import com.gads.crowdfunding.domain.auth.LoginModel
import com.gads.crowdfunding.domain.auth.SignupModel
import com.gads.crowdfunding.network.utility.makeApiRequest
import com.gads.crowdfunding.repository.auth.AuthRepository
import javax.inject.Inject

class AuthRepositoryImplementation @Inject constructor(
    private val authApiService: AuthApiService
): AuthRepository {

    override suspend fun login(loginModel: LoginModel, callback: ApiCallback) {
        makeApiRequest(
            onSuccess = { data -> callback.onSuccess(data) },
            onFailure = { data -> callback.onFailure(data) },
            onError = { throwable -> callback.onError(throwable) },
            apiCall = { authApiService.login(loginModel) }
        )
    }

    override suspend fun signUp(signupModel: SignupModel, callback: ApiCallback) {
        TODO("Not yet implemented")
    }
}