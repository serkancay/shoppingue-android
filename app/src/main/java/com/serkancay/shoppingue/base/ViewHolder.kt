package com.serkancay.shoppingue.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class ViewHolder<T>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T) {
//        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }

}