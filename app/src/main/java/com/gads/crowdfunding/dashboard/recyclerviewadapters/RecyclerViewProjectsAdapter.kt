package com.gads.crowdfunding.dashboard.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gads.crowdfunding.R
import com.gads.crowdfunding.dashboard.recyclerviewtypes.TypeItemProjects
import com.gads.crowdfunding.databinding.ItemRecyclerviewProjectsBinding


class RecyclerViewProjectsAdapter : RecyclerView.Adapter<RecyclerViewProjectsAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemRecyclerviewProjectsBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<TypeItemProjects>(){
        override fun areItemsTheSame(oldItem: TypeItemProjects, newItem: TypeItemProjects): Boolean = (oldItem.id == newItem.id)

        override fun areContentsTheSame(oldItem: TypeItemProjects, newItem: TypeItemProjects): Boolean = (oldItem == newItem)
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var projects : List<TypeItemProjects>
        get() = differ.currentList
        set(value) { differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRecyclerviewProjectsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun getItemCount(): Int = projects.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val project = projects[position]
        holder.binding.apply {


            itemRvImageview.setImageResource(project.imageId)
            itemRvTitle.text = project.title
            itemRvDescription.text = project.description


            itemRvProgressbar.apply{
                progress = project.obtained_amount
                max = project.target_amount
            }

            itemRvTimeLeft.text = project.time_left.toString()
            itemRvTargetAmount.text = project.target_amount.toString()
            itemRvObtainedAmount.text = project.obtained_amount.toString()
            itemRvBtnProjectStatus.text = when(project.projectStatus){
                        true -> "Open"
                        else -> "Closed"
            }
        }

        holder.binding.itemRvBtnProjectStatus.setOnClickListener {
            when(project.projectStatus){
                true -> holder.binding.itemRvBtnProjectStatus.apply{
                    text = "Closed"
                    setBackgroundColor(resources.getColor(R.color.crail))
                }

                false -> holder.binding.itemRvBtnProjectStatus.apply {
                        text = "Open"
                        setBackgroundColor(resources.getColor(R.color.colorPrimary))
                }
            }
        }
    }
}