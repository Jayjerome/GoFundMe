package com.gads.crowdfunding.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.gads.crowdfunding.R
import com.gads.crowdfunding.databinding.FragmentLogInBinding


class LogInFragment : Fragment(R.layout.fragment_log_in) {
    private lateinit var binding: FragmentLogInBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentLogInBinding.bind(view)

        binding.txtGetAnAccount.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }
    }


}