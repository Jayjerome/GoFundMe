package com.gads.crowdfunding.presentation.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gads.crowdfunding.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignIn_LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_log_in)
    }
}