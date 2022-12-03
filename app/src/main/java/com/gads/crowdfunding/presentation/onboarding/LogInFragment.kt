package com.gads.crowdfunding.presentation.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gads.crowdfunding.R
import com.gads.crowdfunding.databinding.FragmentLogInBinding
import com.gads.crowdfunding.domain.auth.LoginModel
import com.gads.crowdfunding.util.LoadingUtils
import com.gads.crowdfunding.util.showToast
import com.gads.crowdfunding.viewmodels.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInFragment : Fragment(R.layout.fragment_log_in) {
    private lateinit var binding: FragmentLogInBinding

    private val viewModel : AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentLogInBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            if(binding.emailTextInput?.text?.isNotEmpty() == true && binding.passwordTextInput?.text?.isNotEmpty() == true) {
                LoadingUtils.showDialog(requireContext(), false)
                viewModel.login(
                    LoginModel(
                        binding.emailTextInput?.text.toString(),
                        binding.passwordTextInput?.text.toString()
                    )
                )
            }else{
                showToast("Missing email or password", requireContext())
            }
//            startActivity(Intent(view.context, NavhostHomeActivity::class.java))
        }

        binding.txtGetAnAccount.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }
    }


}