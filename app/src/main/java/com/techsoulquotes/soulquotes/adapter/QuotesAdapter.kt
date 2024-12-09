package com.techsoulquotes.soulquotes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.techsoulquotes.soulquotes.databinding.QuotesRowItemBinding
import com.techsoulquotes.soulquotes.model.Quotes

class QuotesAdapter(val itemCallback: (Quotes) -> Unit, val itemFavoriteCallback:(Quotes)->Unit):
    ListAdapter<Quotes, QuotesAdapter.QuotesItemViewHolder>(QuotesDiffUtil()) {

    class QuotesItemViewHolder(val binding: QuotesRowItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(quotes: Quotes){
            binding.quotes = quotes
        }
    }

    class QuotesDiffUtil: DiffUtil.ItemCallback<Quotes>(){
        override fun areItemsTheSame(oldItem: Quotes, newItem: Quotes): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Quotes, newItem: Quotes): Boolean {
            return oldItem==newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesItemViewHolder {
        val binding= QuotesRowItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return QuotesItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuotesItemViewHolder, position: Int) {
        val quotes: Quotes =getItem(position)
        holder.bind(quotes)

        holder.binding.shareIVId.setOnClickListener {
            itemCallback(quotes)
        }
        holder.binding.favIVId.setOnClickListener {
            itemFavoriteCallback(quotes)
        }
    }
}
