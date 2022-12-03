package com.gads.crowdfunding.presentation.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gads.crowdfunding.R
import com.gads.crowdfunding.databinding.FragmentThankYouBinding

class ThankYouFragment : Fragment(R.layout.fragment_thank_you){
    private lateinit var  binding: FragmentThankYouBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentThankYouBinding.bind(view)

        binding.fragThankYouBackToHomePage.setOnClickListener {
            findNavController().navigate(R.id.action_thankYouFragment_to_homeFragment)
        }
    }
}