package com.gads.crowdfunding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gads.crowdfunding.databinding.ActivityMainBinding
import com.gads.crowdfunding.onboarding.SignInFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_GoFundMe)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)






    }
}