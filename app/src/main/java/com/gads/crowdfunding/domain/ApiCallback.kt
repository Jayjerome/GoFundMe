package com.gads.crowdfunding.domain

interface ApiCallback {
    fun onSuccess(response: Any)
    fun onFailure(response: DefaultResponse)
    fun onError(exception: Throwable)
}