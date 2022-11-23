package com.gads.crowdfunding.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gads.crowdfunding.R
import com.gads.crowdfunding.dashboard.recyclerviewtypes.DataManager
import com.gads.crowdfunding.databinding.FragmentFundraisingBinding

class FundraisingFragment : Fragment(R.layout.fragment_fundraising){
    private lateinit var binding: FragmentFundraisingBinding
    private val adapterFundraisingRv by lazy {
        RecyclerViewFundraisingFragAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFundraisingBinding.bind(view)

        setUpRecyclerView()
        adapterFundraisingRv.donors = DataManager.initializeItemFundraising()

    }

    private fun setUpRecyclerView() {
        binding.recyclerViewFragmentFundraising.apply {
            adapter = adapterFundraisingRv
           layoutManager = LinearLayoutManager(this@FundraisingFragment.context)
        }
    }

}