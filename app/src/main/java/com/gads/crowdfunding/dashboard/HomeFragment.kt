package com.gads.crowdfunding.dashboard

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gads.crowdfunding.R
import com.gads.crowdfunding.dashboard.recyclerviewadapters.RecyclerViewDashBoardAdapter
import com.gads.crowdfunding.dashboard.recyclerviewtypes.DataManager
import com.gads.crowdfunding.dashboard.recyclerviewtypes.TypeCardViewRV
import com.gads.crowdfunding.databinding.FragmentHomeBinding

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

//        var state : Int? = null
//        binding.recyclerViewDashboard.addOnScrollListener(object : RecyclerView.OnScrollListener(){
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                state = newState
//            }
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//
//                if(dy > 0 && (state == 0 || state == 2)){
//                    binding.collapsingtoolbarlayout.scrollBy(0, 100)
//                    binding.toolbar.isVisible = true
//                }else if (dy < -10){
//                    binding.collapsingtoolbarlayout.scrollBy(0,100)
//                    binding.toolbar.isVisible = false
//                }
//            }
//        })
    }

    private fun setUpRecyclerView() {
        val cards :ArrayList<TypeCardViewRV> = DataManager.initializeCards()

        recyclerViewAdapter.cards = cards
        binding.recyclerViewDashboard.adapter = recyclerViewAdapter
        binding.recyclerViewDashboard.layoutManager = LinearLayoutManager(this.context)
    }
}