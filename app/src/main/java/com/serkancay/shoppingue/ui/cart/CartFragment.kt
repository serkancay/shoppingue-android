package com.serkancay.shoppingue.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.serkancay.shoppingue.databinding.FragmentCartBinding
import com.serkancay.shoppingue.ui.main.ProductsViewModel

class CartFragment : Fragment() {

    private val viewModel: ProductsViewModel by activityViewModels()

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        val cartProductsAdapter = CartProductsAdapter()
        binding.cartProductsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.cartProductsRecyclerView.adapter = cartProductsAdapter
        binding.cartProductsRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        viewModel.cartProducts.observe(viewLifecycleOwner, { products ->
            cartProductsAdapter.submitList(products)
        })
        viewModel.refreshCartProducts()
    }

}
