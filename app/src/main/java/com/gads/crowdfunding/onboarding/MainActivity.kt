package com.gads.crowdfunding.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.gads.crowdfunding.R
import com.gads.crowdfunding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_GoFundMe)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val btnBottomSheet_signIn = findViewById<Button>(R.id.btn_bottomSheet_SingIn)

        btnBottomSheet_signIn.setOnClickListener {
            startActivity(Intent(this, SignIn_LogIn::class.java))
        }

    }
}