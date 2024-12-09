package com.techsoulquotes.soulquotes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.techsoulquotes.soulquotes.R
import com.techsoulquotes.soulquotes.adapter.HomeCategoryAdapter
import com.techsoulquotes.soulquotes.databinding.FragmentHomeBinding
import com.techsoulquotes.soulquotes.model.Category
import com.techsoulquotes.soulquotes.model.categoryList


class HomeFragment : Fragment() {
private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        getAdapter()
        return binding.root
    }

    private fun getAdapter() {
        val categoryAdapter= HomeCategoryAdapter(::onItemClicked)
        binding.homeRecyclerView.layoutManager= GridLayoutManager(requireActivity(),2)
        binding.homeRecyclerView.adapter=categoryAdapter
        categoryAdapter.submitList(categoryList)
    }

    private fun onItemClicked(category: Category) {

        Toast.makeText(context, ""+category.id, Toast.LENGTH_SHORT).show()

        val bundle= bundleOf("id" to category.id)
        findNavController().navigate(R.id.action_homeFragment_to_topicViewFragment,bundle)

    }
}