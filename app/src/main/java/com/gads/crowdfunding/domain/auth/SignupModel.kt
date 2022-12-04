package com.gads.crowdfunding.domain.auth

data class SignupModel(
    val firstname: String,
    val lastname: String,
    val email: String,
    val phonenumber: String,
    val password: String,
    val passwordConfirm: String,
    val role: String,
)
