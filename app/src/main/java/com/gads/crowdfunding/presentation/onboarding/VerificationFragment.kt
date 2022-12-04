package com.gads.crowdfunding.onboarding

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gads.crowdfunding.R
import com.gads.crowdfunding.databinding.FragmentVerificationBinding
import com.gads.crowdfunding.presentation.dashboard.NavhostHomeActivity
import com.gads.crowdfunding.viewmodel.onboardingviewmodel.OnboardingViewModel

class VerificationFragment : Fragment(R.layout.fragment_verification){
    private lateinit var binding: FragmentVerificationBinding
    private val onboardingViewModel : OnboardingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVerificationBinding.bind(view)

        binding.btnVerify.setOnClickListener {
            if(onboardingViewModel.isVerififcationMatching()) {
                startActivity(Intent(view.context, NavhostHomeActivity::class.java))
            }else{
                binding.edtVerify.apply{
                    error = "Invalid code"
                    isErrorEnabled = true
                }

                //For API 28 and above  we are reseting the errors after 10 seconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    Handler.createAsync(Looper.myLooper()!!).postDelayed({
                        binding.edtVerify.isErrorEnabled = false
                    }, 10000)
                }
            }
        }
    }
}