package com.techsoulquotes.soulquotes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.techsoulquotes.soulquotes.databinding.HomeRowItemBinding
import com.techsoulquotes.soulquotes.model.Category

class HomeCategoryAdapter(val itemCallback: (Category) ->Unit):
    ListAdapter<Category, HomeCategoryAdapter.CategoryItemViewHolder>(TopicDiffUtil()) {

    class CategoryItemViewHolder(val binding:HomeRowItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(category: Category){
            binding.category=category
        }
    }

    class TopicDiffUtil: DiffUtil.ItemCallback<Category>(){
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem==newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        val binding=HomeRowItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return CategoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        val category:Category=getItem(position)
        holder.bind(category)

        holder.itemView.setOnClickListener {
            itemCallback(category)
        }
    }
}
