package com.gads.crowdfunding.presentation.dashboard.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gads.crowdfunding.presentation.dashboard.HomeFragmentDirections
import com.gads.crowdfunding.presentation.dashboard.recyclerviewtypes.TypeItemDashBoad
import com.gads.crowdfunding.databinding.ItemRecyclerviewDashboardBinding

class RecyclerViewDashBoardAdapter: RecyclerView.Adapter<RecyclerViewDashBoardAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemRecyclerviewDashboardBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<TypeItemDashBoad>(){
        override fun areItemsTheSame(oldItem: TypeItemDashBoad, newItem: TypeItemDashBoad): Boolean = (oldItem.id == newItem.id)
        override fun areContentsTheSame(oldItem: TypeItemDashBoad, newItem: TypeItemDashBoad): Boolean = (oldItem == newItem)
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    var cards : List<TypeItemDashBoad>
        get() =differ.currentList
        set(value) { differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRecyclerviewDashboardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun getItemCount(): Int = cards.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val card = cards[position]

            itemRvImageview.setImageResource(card.imageId)
            itemRvTitle.text = card.title
            itemRvDescription.text = card.description


            itemRvProgressbar.apply{
                progress = card.obtained_amount
                max = card.target_amount
            }

            itemRvTimeLeft.text = card.time_left.toString()
            itemRvTargetAmount.text = card.target_amount.toString()
            itemRvObtainedAmount.text = card.obtained_amount.toString()


        }

        //Starting the fundraising Fragment and passing the current position clicked on the recycler View
        holder.binding.itemRvCardView.setOnClickListener {
            findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToFundraisingFragment(position))

        }

    }

}