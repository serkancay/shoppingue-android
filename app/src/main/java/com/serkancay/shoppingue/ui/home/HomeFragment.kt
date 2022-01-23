package com.serkancay.shoppingue.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.serkancay.shoppingue.databinding.FragmentHomeBinding
import com.serkancay.shoppingue.ui.main.ProductsViewModel

class HomeFragment : Fragment() {

    private val viewModel: ProductsViewModel by activityViewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productsAdapter = ProductsAdapter {
            viewModel.addProductToCart(it.second)
        }
        binding.productsRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.productsRecyclerView.adapter = productsAdapter
        viewModel.products.observe(viewLifecycleOwner, {
            productsAdapter.submitList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}