package com.gads.crowdfunding.network.auth

import com.gads.crowdfunding.domain.auth.LoginModel
import com.gads.crowdfunding.domain.auth.AuthNetworkResponse
import com.gads.crowdfunding.domain.auth.SignupModel
import com.gads.crowdfunding.domain.auth.VerificationModel
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.*

interface AuthApiService {

    @POST("auth/login")
    fun login(
        @Body loginDetails: LoginModel,
    ): Call<AuthNetworkResponse>

    @POST("auth/signup")
    fun signup(
        @Body signupModel: SignupModel,
    ): Call<AuthNetworkResponse>

    @POST("auth/verifyemail")
    fun verifyEmail(
        @Body verificationModel: VerificationModel,
    ): Call<AuthNetworkResponse>

}


