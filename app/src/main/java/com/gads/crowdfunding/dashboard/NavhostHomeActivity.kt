package com.gads.crowdfunding.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.gads.crowdfunding.R
import com.gads.crowdfunding.databinding.ActivityNavHostHomeBinding

class NavhostHomeActivity: AppCompatActivity() {
    private lateinit var binding : ActivityNavHostHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavHostHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}