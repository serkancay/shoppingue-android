package com.serkancay.shoppingue.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serkancay.shoppingue.model.Product

class ProductsViewModel : ViewModel() {

    private val _products = MutableLiveData<List<Pair<Boolean, Product>>>()
    private val _cartProducts = MutableLiveData<List<Product>>()

    val products: LiveData<List<Pair<Boolean, Product>>> = _products
    val cartProducts: LiveData<List<Product>> = _cartProducts

    init {
        getProducts()
    }

    private fun getProducts() {
        _products.value = listOf(
            Pair(false, Product(1, "Pringles", "https://loremflickr.com/300/300/pringles", "₺29.90")),
            Pair(false, Product(2, "Powerbank", "https://loremflickr.com/300/300/powerbank", "₺119.90")),
            Pair(false, Product(3, "Orange 1 Kg", "https://loremflickr.com/300/300/orange,fruit", "₺3.70")),
            Pair(false, Product(4, "Water Small", "https://loremflickr.com/300/300/water", "₺1.50")),
            Pair(false, Product(5, "Chocolate Bar", "https://loremflickr.com/300/300/chocolate", "₺21.65")),
            Pair(false, Product(6, "Bread", "https://loremflickr.com/300/300/bread", "₺2.00")),
        )
    }

    fun refreshCartProducts() {
        _cartProducts.value = _products.value?.filter { it.first }?.map { it.second }
    }

    fun addProductToCart(product: Product) {
        val allProducts = _products.value?.toMutableList() ?: return
        allProducts.forEachIndexed { index, pair ->
            if (pair.second.id == product.id) {
                allProducts[index] = pair.copy(first = true)
            }
        }
        _products.postValue(allProducts)
        refreshCartProducts()
    }

}