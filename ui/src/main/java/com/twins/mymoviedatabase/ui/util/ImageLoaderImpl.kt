package com.twins.mymoviedatabase.ui.glide

import android.annotation.SuppressLint
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.RequestOptions

/**
 * Created by bukalapak on 11/20/17.
 */
object ImageLoaderImpl : ImageLoader {

    @SuppressLint("CheckResult")
    override fun load(view: ImageView,
                      url: GlideUrl?,
                      placeholderColor: Int?,
                      placeholderDrawable: Int?) {
        val builder = Glide.with(view).load(url)

        builder.apply(RequestOptions().apply {
            placeholder(placeholderColor ?: placeholderDrawable ?: 0)
        })

        builder.into(view)
    }

}