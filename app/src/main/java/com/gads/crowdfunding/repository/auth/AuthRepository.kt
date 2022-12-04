package com.gads.crowdfunding.repository.auth

import com.gads.crowdfunding.domain.ApiCallback
import com.gads.crowdfunding.domain.auth.LoginModel
import com.gads.crowdfunding.domain.auth.SignupModel

interface AuthRepository {

    suspend fun login(
        loginModel: LoginModel,
        callback: ApiCallback
    )

    suspend fun signUp(
        signupModel: SignupModel,
        callback: ApiCallback
    )
}