package com.gads.crowdfunding.presentation.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gads.crowdfunding.R
import com.gads.crowdfunding.databinding.ActivityNavHostHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavhostHomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host_home)

    }

}