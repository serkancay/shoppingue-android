package com.serkancay.shoppingue.ui.completed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.serkancay.shoppingue.R
import com.serkancay.shoppingue.databinding.FragmentCompletedBinding
import com.serkancay.shoppingue.ui.main.ProductsViewModel

class CompletedFragment : Fragment() {

    private val viewModel: ProductsViewModel by activityViewModels()

    private var _binding: FragmentCompletedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCompletedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            fragment = this@CompletedFragment
        }
        viewModel.clearCart()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onClickReturnToHome() {
        findNavController().navigate(R.id.action_completedFragment_to_homeFragment)
    }

}