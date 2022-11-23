package com.gads.crowdfunding.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gads.crowdfunding.dashboard.recyclerviewtypes.TypeItemFundraising
import com.gads.crowdfunding.databinding.ItemRecyclerviewFundraisingBinding

class RecyclerViewFundraisingFragAdapter : RecyclerView.Adapter<RecyclerViewFundraisingFragAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ItemRecyclerviewFundraisingBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<TypeItemFundraising>(){
        override fun areItemsTheSame(oldItem: TypeItemFundraising, newItem: TypeItemFundraising): Boolean = (oldItem.id == newItem.id)
        override fun areContentsTheSame(oldItem: TypeItemFundraising, newItem: TypeItemFundraising): Boolean = (oldItem == newItem)
    }


    private val differ = AsyncListDiffer(this, diffCallback)

    var donors : List<TypeItemFundraising>
        get() = differ.currentList
        set(value) { differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRecyclerviewFundraisingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun getItemCount(): Int  = donors.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val donor = donors[position]

            itemRvFundraisingImageview.setImageResource(donor.imageView)
            itemRvFundraisingDonorName.text = donor.donorName
            itemRvFundraisingDonorAmount.text = "$" + donor.donorAmount.toString()
        }
    }
}