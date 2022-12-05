package com.gads.crowdfunding.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gads.crowdfunding.domain.ApiCallback
import com.gads.crowdfunding.domain.DefaultResponse
import com.gads.crowdfunding.domain.auth.AuthNetworkResponse
import com.gads.crowdfunding.domain.auth.LoginModel
import com.gads.crowdfunding.presentation.onboarding.ERROR
import com.gads.crowdfunding.presentation.onboarding.FAILURE
import com.gads.crowdfunding.presentation.onboarding.SUCCESS
import com.gads.crowdfunding.repository.auth.AuthRepository
import com.gads.crowdfunding.util.Constants.Companion.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    val authRepository: AuthRepository
) : ViewModel() {

    var email = ""
    var password = ""


    fun isFieldsEmpty(): Boolean = email.isBlank() && password.isBlank()

    private var _loginResponse = MutableLiveData<AuthNetworkResponse>()
    val loginResponseLiveData: LiveData<AuthNetworkResponse> = _loginResponse


    fun login(loginModel: LoginModel) {
        try {
            viewModelScope.launch {
                authRepository.login(loginModel, object : ApiCallback {
                    override fun onSuccess(response: Any) {
                        Log.i(TAG, "login: $response")
                        _loginResponse.value = AuthNetworkResponse(true, "Success")
                    }

                    override fun onFailure(response: DefaultResponse) {
                        Log.i(TAG, "login: $response")
                        _loginResponse.value = AuthNetworkResponse(false, "Failed, unable to process request")
                    }

                    override fun onError(exception: Throwable) {
                        Log.i(TAG, "login: $exception")
                        _loginResponse.value = AuthNetworkResponse(false, "Failed. Try again")
                    }

                })
            }
        } catch (e: Exception) {
            Log.i(TAG, "login: $e")
            _loginResponse.value = AuthNetworkResponse(false, "Failed, network error")
        }
    }
}