package com.gads.crowdfunding.dashboard

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gads.crowdfunding.R
import com.gads.crowdfunding.dashboard.recyclerviewadapters.RecyclerViewFundraisingFragAdapter
import com.gads.crowdfunding.dashboard.recyclerviewtypes.DataManager
import com.gads.crowdfunding.databinding.FragmentFundraisingBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class FundraisingFragment : Fragment(R.layout.fragment_fundraising){
    private lateinit var binding: FragmentFundraisingBinding
    private val adapterFundraisingRv by lazy {
        RecyclerViewFundraisingFragAdapter()
    }
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFundraisingBinding.bind(view)

        setUpRecyclerView()
        adapterFundraisingRv.donors = DataManager.initializeItemFundraising()


        val bottomSheetBehavior = setUpBottomSheet(view)

        binding.fragFundraisingBtnDonate.setOnClickListener {
                val state =
                    if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                        BottomSheetBehavior.STATE_COLLAPSED
                    else
                        BottomSheetBehavior.STATE_EXPANDED
                bottomSheetBehavior.state = state
        }

        //Bottom Sheet donate button
        val addDonation =  view.findViewById<Button>(R.id.btn_add_donation)
        addDonation.setOnClickListener {
            findNavController().navigate(R.id.action_fundraisingFragment_to_thankYouFragment)
        }

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_fundraisingFragment_to_homeFragment)
        }


        val state  = IntArray(1)

        binding.recyclerViewFragmentFundraising.addOnScrollListener(object :
            RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                state[0] = newState
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if(dy > 0 && (state[0] == 0 || state[0] == 2)){
                    hideToolbar();
                }else if (dy < -20){
                    showToolbar()
                }
            }
        })

    }

    private fun hideToolbar() {
        binding.relativeLayout.isVisible = false
    }

    private fun showToolbar() {
        binding.relativeLayout.isVisible = true
    }

    private fun setUpBottomSheet(view: View): BottomSheetBehavior<LinearLayout> {
        val bottomsheet = view.findViewById<LinearLayout>(R.id.bottom_sheet_fundraising)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet)

        return bottomSheetBehavior
    }


    private fun setUpRecyclerView() {
        binding.recyclerViewFragmentFundraising.apply {
            adapter = adapterFundraisingRv
           layoutManager = LinearLayoutManager(this@FundraisingFragment.context)
        }
    }

}