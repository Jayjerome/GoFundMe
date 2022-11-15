package com.gads.crowdfunding.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.gads.crowdfunding.R
import com.gads.crowdfunding.databinding.FragmentSignUpBinding

class SignIn_LogIn : AppCompatActivity() {
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_log_in)

        binding = FragmentSignUpBinding.inflate(layoutInflater)

    binding.txtHaveAnAccount.setOnClickListener {
        findNavController(R.id.fragmentContainerView).navigate(R.id.action_signUpFragment_to_logInFragment)
    }


    }
}