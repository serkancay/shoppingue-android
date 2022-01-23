package com.serkancay.shoppingue.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serkancay.shoppingue.model.Product

class ProductsViewModel : ViewModel() {

    private val randomImageUrl = "https://picsum.photos/300"

    private val _products = MutableLiveData<List<Product>>()

    val products: LiveData<List<Product>> = _products

    init {
        getProducts()
    }

    private fun getProducts() {
        _products.value = mutableListOf(
            Product(1, "Pringles", randomImageUrl, "₺29.90"),
            Product(2, "Powerbank", randomImageUrl, "₺119.90"),
            Product(3, "Portakal Kg", randomImageUrl, "₺3.70"),
        )
    }

}