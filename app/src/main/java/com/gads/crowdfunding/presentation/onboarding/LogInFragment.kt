package com.gads.crowdfunding.presentation.onboarding

import android.content.Intent
import android.os.*
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gads.crowdfunding.R
import com.gads.crowdfunding.databinding.FragmentLogInBinding
import com.gads.crowdfunding.presentation.dashboard.NavhostHomeActivity
import com.gads.crowdfunding.util.LoadingUtils
import com.gads.crowdfunding.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInFragment : Fragment(R.layout.fragment_log_in) {
    private lateinit var binding: FragmentLogInBinding
    private val viewModel: AuthViewModel by viewModels()
    private val TAG = "Log in Fragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentLogInBinding.bind(view)



        binding.emailTextInput.doOnTextChanged { text, start, before, count ->
            viewModel.email = text.toString()
        }
        binding.editTextPassword.doOnTextChanged { text, start, before, count ->
            viewModel.password = text.toString()
        }

        binding.btnLogin.setOnClickListener {
            if (viewModel.isFieldsEmpty()) {
                Log.e(TAG, "Fields are empty")
                binding.errorFieldsareEmpty?.isVisible = true
                binding.edtEmail.apply {
                    error = "Empty field"
                    isErrorEnabled = true
                }
                binding.edtPassword.apply {
                    error = "Empty field"
                    isErrorEnabled = true
                }

                //For API 28 and above  we are reseting the errors after 10 seconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    Handler.createAsync(Looper.myLooper()!!).postDelayed({
                        binding.edtEmail.isErrorEnabled = false
                        binding.edtPassword.isErrorEnabled = false
                        binding.errorFieldsareEmpty?.isVisible = false
                    }, 10000)
                }
            } else {
                viewModel.loginResponseLiveData.observe(viewLifecycleOwner) {
                    if (it.success) {
                        Log.i(TAG, "Credentials are valid")
                        startActivity(Intent(view.context, NavhostHomeActivity::class.java))
                    } else {
                        Log.e(TAG, "Invalid Credentials given")
                        LoadingUtils.hideDialog()

                        //Show an error message and enable errors for the textInputLayout
                        binding.errorTextInvalidCredentials.isVisible = true
                        binding.edtEmail.apply {
                            error = "Invalid email"
                            isErrorEnabled = true
                        }
                        binding.edtPassword.apply {
                            error = "Invalid password"
                            isErrorEnabled = true
                        }

                        //For API 28 and above  we are reseting the errors after 10 seconds
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                            Handler.createAsync(Looper.myLooper()!!).postDelayed({
                                binding.edtEmail.isErrorEnabled = false
                                binding.edtPassword.isErrorEnabled = false
                                binding.errorTextInvalidCredentials.isVisible = false
                            }, 10000)
                        }

                    }
                }

            }

            binding.txtGetAnAccount.setOnClickListener {
                findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
            }
        }
    }
}
