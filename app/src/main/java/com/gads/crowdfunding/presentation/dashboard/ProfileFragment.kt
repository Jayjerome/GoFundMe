package com.gads.crowdfunding.presentation.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gads.crowdfunding.R
import com.gads.crowdfunding.presentation.dashboard.dialogfragments.UpdateProfileDialog
import com.gads.crowdfunding.presentation.dashboard.recyclerviewadapters.RecyclerViewProjectsAdapter
import com.gads.crowdfunding.presentation.dashboard.recyclerviewtypes.DataManager
import com.gads.crowdfunding.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile){
    private lateinit var binding: FragmentProfileBinding
    private lateinit var recyclerViewProjectsAdapter: RecyclerViewProjectsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        binding.backButton.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
        }

        setUpRecyclerView()

        binding.updateProfile.setOnClickListener {
            UpdateProfileDialog().show(parentFragmentManager, "Update profile ")
        }
    }

    private fun setUpRecyclerView() {
        binding.recyclerViewProfileYourProjects.apply {
            recyclerViewProjectsAdapter = RecyclerViewProjectsAdapter()
            recyclerViewProjectsAdapter.projects = DataManager.initializeProjects()

            adapter = recyclerViewProjectsAdapter
            layoutManager = LinearLayoutManager(this@ProfileFragment.context)
        }


    }
}