package com.gads.crowdfunding.presentation.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gads.crowdfunding.R
import com.gads.crowdfunding.presentation.dashboard.recyclerviewadapters.RecyclerViewDashBoardAdapter
import com.gads.crowdfunding.presentation.dashboard.recyclerviewtypes.DataManager
import com.gads.crowdfunding.presentation.dashboard.recyclerviewtypes.TypeCardViewRV
import com.gads.crowdfunding.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var binding : FragmentHomeBinding
    private val recyclerViewAdapter by lazy {
        RecyclerViewDashBoardAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.fragHomeBtnAddProject.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_newProjectFragment)
        }

        setUpRecyclerView()

        //Home fragment to see profile fragment
        binding.linearLayoutProfileView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
    }

    private fun setUpRecyclerView() {
        val cards :ArrayList<TypeCardViewRV> = DataManager.initializeCards()

        recyclerViewAdapter.cards = cards
        binding.recyclerViewDashboard.adapter = recyclerViewAdapter
        binding.recyclerViewDashboard.layoutManager = LinearLayoutManager(this.context)
    }
}