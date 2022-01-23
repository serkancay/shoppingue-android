package com.serkancay.shoppingue.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.serkancay.shoppingue.databinding.ItemProductBinding
import com.serkancay.shoppingue.model.Product

class ProductsAdapter(private val onAddToCartClicked: (Pair<Boolean, Product>) -> Unit) : ListAdapter<Pair<Boolean, Product>, ProductsAdapter.ProductViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = ProductViewHolder(
            binding
        )
        binding.addToCartImageButton.setOnClickListener {
            onAddToCartClicked.invoke(getItem(viewHolder.adapterPosition))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductViewHolder(private var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Pair<Boolean, Product>) {
            binding.item = product.second
            binding.addToCartImageButton.isVisible = !product.first
            binding.productAddedImageView.isVisible = product.first
            binding.executePendingBindings()
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Pair<Boolean, Product>>() {
            override fun areItemsTheSame(oldItem: Pair<Boolean, Product>, newItem: Pair<Boolean, Product>): Boolean {
                return oldItem.second.id == newItem.second.id && oldItem.first == newItem.first
            }

            override fun areContentsTheSame(oldItem: Pair<Boolean, Product>, newItem: Pair<Boolean, Product>): Boolean {
                return oldItem.second.name == newItem.second.name &&
                        oldItem.second.prettyPrice == newItem.second.prettyPrice &&
                        oldItem.second.imageUrl == newItem.second.imageUrl
            }
        }
    }

}