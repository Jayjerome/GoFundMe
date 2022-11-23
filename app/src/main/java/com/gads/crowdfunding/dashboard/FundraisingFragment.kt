package com.gads.crowdfunding.dashboard

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gads.crowdfunding.R
import com.gads.crowdfunding.dashboard.recyclerviewtypes.DataManager
import com.gads.crowdfunding.databinding.FragmentFundraisingBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

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