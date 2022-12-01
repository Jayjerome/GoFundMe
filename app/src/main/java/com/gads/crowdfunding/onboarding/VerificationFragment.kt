package com.gads.crowdfunding.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gads.crowdfunding.R
import com.gads.crowdfunding.dashboard.NavhostHomeActivity
import com.gads.crowdfunding.databinding.FragmentVerificationBinding

class VerificationFragment : Fragment(R.layout.fragment_verification){
    private lateinit var binding: FragmentVerificationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVerificationBinding.bind(view)

        binding.btnVerify.setOnClickListener {
            startActivity(Intent(view.context,NavhostHomeActivity::class.java))
        }
    }
}