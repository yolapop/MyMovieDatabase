package com.twins.mymoviedatabase.ui.util

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.bumptech.glide.load.model.GlideUrl

/**
 * Created by bukalapak on 11/16/17.
 */
fun ImageView.setImageUrl(url: String?,
                          @ColorRes placeholderColor: Int? = null,
                          @DrawableRes placeholderDrawable: Int? = null) {

    ImageLoader.load(view = this, url = url?.let {  GlideUrl(url) },
            placeholderColor = placeholderColor,
            placeholderDrawable =  placeholderDrawable)
}

@SuppressLint("CheckResult")
fun ImageView.setImageGlideUrl(url: GlideUrl?,
                               @ColorRes placeholderColor: Int? = null,
                               @DrawableRes placeholderDrawable: Int? = null) {

    ImageLoader.load(view = this, url = url, placeholderColor =  placeholderColor, placeholderDrawable =  placeholderDrawable)
}
