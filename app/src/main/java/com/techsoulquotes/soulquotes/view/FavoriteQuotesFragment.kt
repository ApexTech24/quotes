package com.techsoulquotes.soulquotes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.techsoulquotes.soulquotes.R
import com.techsoulquotes.soulquotes.adapter.QuotesAdapter
import com.techsoulquotes.soulquotes.databinding.FragmentFavoriteQuotesBinding
import com.techsoulquotes.soulquotes.model.Quotes
import com.techsoulquotes.soulquotes.viewModels.FavoriteQuotesViewModel


class FavoriteQuotesFragment : Fragment() {
    private lateinit var binding:FragmentFavoriteQuotesBinding

    private val favoriteQuotesViewModel:FavoriteQuotesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentFavoriteQuotesBinding.inflate(inflater,container,false)

        val favoriteQuotesAdapter= QuotesAdapter(::onItemClicked, ::onItemFavoriteClicked)
        binding.favoriteQuotesRecyclerView.layoutManager= LinearLayoutManager(requireActivity())
        binding.favoriteQuotesRecyclerView.adapter=favoriteQuotesAdapter
        favoriteQuotesViewModel.getAllFavoriteQuotes().observe(viewLifecycleOwner){
            favoriteQuotesAdapter.submitList(it)
        }
        return binding.root
    }

    private fun onItemClicked(quotes: Quotes) {

        Toast.makeText(context, ""+quotes.id, Toast.LENGTH_SHORT).show()

    }
    private fun onItemFavoriteClicked(quotes: Quotes) {

        favoriteQuotesViewModel.deleteFavoriteQuotes(quotes)

        Toast.makeText(context, "Delete Successful", Toast.LENGTH_SHORT).show()

    }

}