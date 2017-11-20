package com.twins.mymoviedatabase.ui.util

import android.annotation.SuppressLint
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.RequestOptions
import com.twins.mymoviedatabase.ui.glide.ImageLoader
import com.twins.mymoviedatabase.ui.glide.ImageLoaderImpl

/**
 * Created by bukalapak on 11/16/17.
 */
var IMAGE_LOADER: ImageLoader = ImageLoaderImpl

fun ImageView.setImageUrl(url: String?,
                          @ColorRes placeholderColor: Int? = null,
                          @DrawableRes placeholderDrawable: Int? = null) {

    setImageGlideUrl(url = url?.let {  GlideUrl(url) },
            placeholderColor = placeholderColor,
            placeholderDrawable =  placeholderDrawable)
}

@SuppressLint("CheckResult")
fun ImageView.setImageGlideUrl(url: GlideUrl?,
                               @ColorRes placeholderColor: Int? = null,
                               @DrawableRes placeholderDrawable: Int? = null) {
    val builder = Glide.with(this).load(url)

    builder.apply(RequestOptions().apply {
        placeholder(placeholderColor ?: placeholderDrawable ?: 0)
    })

    builder.into(this)
}