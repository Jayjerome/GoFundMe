package com.gads.crowdfunding.presentation.onboarding

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gads.crowdfunding.R
import com.gads.crowdfunding.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import com.gads.crowdfunding.viewmodel.onboardingviewmodel.OnboardingViewModel

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_sign_up){
    private lateinit var binding: FragmentSignUpBinding
    private val onboardingViewModel : OnboardingViewModel by viewModels()
    private val TAG = "SIGNUP_FRAGMENT"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSignUpBinding.bind(view)

        //Capture real time info from the user to the view model
        binding.edittextFirstName.doOnTextChanged { text, start, before, count ->  onboardingViewModel.firstName = text.toString()}
        binding.edittextLastName.doOnTextChanged { text, start, before, count -> onboardingViewModel.lastName = text.toString() }
        binding.emailTextInput.doOnTextChanged { text, start, before, count -> onboardingViewModel.email = text.toString() }
        binding.editTextPassword.doOnTextChanged { text, start, before, count -> onboardingViewModel.password = text.toString() }

        binding.btnSignUp.setOnClickListener {
            //Check whether the first and last name fields are blank
            if(onboardingViewModel.isFirstNameBlank() && onboardingViewModel.isLastNameBlank()){
                Log.e(TAG, "Fields are blank")
                binding.errorTextBlankName.isVisible = true
                binding.edtFirstName.apply {
                    error = "First name is blank"
                    isErrorEnabled = true
                }
                binding.edtLastName.apply {
                    error = "Last name is blank"
                    isErrorEnabled = true
                }
                //For API 28 and above  we are reseting the errors after 10 seconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    Handler.createAsync(Looper.myLooper()!!).postDelayed({
                        binding.errorTextBlankName.isVisible = false
                        binding.edtFirstName.isErrorEnabled = false
                        binding.edtLastName.isErrorEnabled = false
                    }, 10000)
                }
            }else {
                if (onboardingViewModel.isEmailBlank() && onboardingViewModel.isPasswordBlank()){
                    binding.errorTextBlankName.isVisible = true
                    binding.edtEmail.apply {
                        error = "Email is blank"
                        isErrorEnabled = true
                    }
                    binding.edtPassword.apply {
                        error = "Password is blank"
                        isErrorEnabled = true
                    }

                    //For API 28 and above  we are reseting the errors after 10 seconds
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        Handler.createAsync(Looper.myLooper()!!).postDelayed({
                            binding.errorTextBlankName.isVisible = false
                            binding.edtPassword.isErrorEnabled = false
                            binding.edtEmail.isErrorEnabled = false
                        }, 10000)
                    }
                }else {
                    Log.i(TAG, "Sign up successful")
                    findNavController().navigate(R.id.action_signUpFragment_to_verificationFragment)

                }
            }

        }

        binding.txtHaveAnAccount.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)
        }
    }
}