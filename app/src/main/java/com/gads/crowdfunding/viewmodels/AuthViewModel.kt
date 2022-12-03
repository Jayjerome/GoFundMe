package com.gads.crowdfunding.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gads.crowdfunding.domain.ApiCallback
import com.gads.crowdfunding.domain.DefaultResponse
import com.gads.crowdfunding.domain.auth.LoginModel
import com.gads.crowdfunding.repository.auth.AuthRepository
import com.gads.crowdfunding.util.Constants.Companion.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    val authRepository: AuthRepository
) : ViewModel() {


    fun login(loginModel: LoginModel) {
        try {
            viewModelScope.launch {
                authRepository.login(loginModel, object : ApiCallback {
                    override fun onSuccess(response: Any) {
                        Log.i(TAG, "login: $response")
                    }

                    override fun onFailure(response: DefaultResponse) {
                        Log.i(TAG, "login: $response")
                    }

                    override fun onError(exception: Throwable) {
                        Log.i(TAG, "login: $exception")
                    }

                })
            }
        } catch (e: Exception) {
            Log.i(TAG, "login: $e")
        }
    }
}