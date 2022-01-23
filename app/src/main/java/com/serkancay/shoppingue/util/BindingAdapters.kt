package com.serkancay.shoppingue.util

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String) {
    val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
    imageView.load(imageUri)
}
