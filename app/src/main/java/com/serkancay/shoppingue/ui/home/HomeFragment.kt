package com.serkancay.shoppingue.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.serkancay.shoppingue.databinding.FragmentHomeBinding
import com.serkancay.shoppingue.model.Product

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productsAdapter = ProductsAdapter { }
        productsAdapter.submitList(mutableListOf(
            Product(1, "Pringles", "https://picsum.photos/300", "₺29.90"),
            Product(2, "Powerbank", "https://picsum.photos/300", "₺119.90"),
            Product(3, "Portakal Kg", "https://picsum.photos/300", "₺3.70"),
        ))

        binding.productsRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.productsRecyclerView.adapter = productsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}