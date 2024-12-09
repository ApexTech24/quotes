package com.techsoulquotes.soulquotes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.techsoulquotes.soulquotes.adapter.QuotesAdapter
import com.techsoulquotes.soulquotes.databinding.FragmentTopicViewBinding
import com.techsoulquotes.soulquotes.db.quotes1List
import com.techsoulquotes.soulquotes.db.quotes2List
import com.techsoulquotes.soulquotes.db.quotes3List
import com.techsoulquotes.soulquotes.db.quotes4List
import com.techsoulquotes.soulquotes.db.quotes5List
import com.techsoulquotes.soulquotes.db.quotes6List
import com.techsoulquotes.soulquotes.db.quotes7List
import com.techsoulquotes.soulquotes.db.quotes8List
import com.techsoulquotes.soulquotes.model.Quotes
import com.techsoulquotes.soulquotes.viewModels.FavoriteQuotesViewModel


class TopicViewFragment : Fragment() {

    private lateinit var binding: FragmentTopicViewBinding
    private val favoriteQuotesViewModel: FavoriteQuotesViewModel by activityViewModels()

    private var id:Int? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentTopicViewBinding.inflate(inflater,container,false)

        id=arguments?.getInt("id")
        getAdapter(id)
        return binding.root
    }

    private fun getAdapter(id: Int?) {
        val quotesAdapter= QuotesAdapter(::onItemClicked, ::onItemFavoriteClicked)
        binding.quotesRecyclerView.layoutManager= LinearLayoutManager(requireActivity())
        binding.quotesRecyclerView.adapter=quotesAdapter
        if (id==1){
            quotesAdapter.submitList(quotes1List)
        }
        else if (id==2){
            quotesAdapter.submitList(quotes2List)

        } else if (id==3){
            quotesAdapter.submitList(quotes3List)

        } else if (id==4){
            quotesAdapter.submitList(quotes4List)

        } else if (id==4){
            quotesAdapter.submitList(quotes5List)

        } else if (id==6){
            quotesAdapter.submitList(quotes6List)

        } else if (id==7){
            quotesAdapter.submitList(quotes7List)

        } else {
            quotesAdapter.submitList(quotes8List)

        }
    }

    private fun onItemClicked(quotes: Quotes) {

        Toast.makeText(context, ""+quotes.id, Toast.LENGTH_SHORT).show()

    }
    private fun onItemFavoriteClicked(quotes: Quotes) {

        val addFavorite = Quotes(
            id = quotes.id,
            mQuote =quotes.mQuote,
            isFavorite = quotes.isFavorite
        )
        favoriteQuotesViewModel.insertFavoriteQuotes(addFavorite)
        /*if (quotes.isFavorite){
            favoriteQuotesViewModel.insertFavoriteQuotes(addFavorite)
        }
        else{
            favoriteQuotesViewModel.deleteFavoriteQuotes(quotes)

        }
*/
        Toast.makeText(context, ""+quotes.mQuote, Toast.LENGTH_SHORT).show()

    }
}