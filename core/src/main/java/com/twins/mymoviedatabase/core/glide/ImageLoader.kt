package com.twins.mymoviedatabase.ui.glide

import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.load.model.GlideUrl

/**
 * Created by bukalapak on 11/20/17.
 */
interface ImageLoader {

    fun load(view: ImageView, url: GlideUrl?,
             @ColorRes placeholderColor: Int? = null,
             @DrawableRes placeholderDrawable: Int? = null)

}