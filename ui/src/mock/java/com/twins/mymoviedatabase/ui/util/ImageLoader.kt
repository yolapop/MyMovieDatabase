package com.twins.mymoviedatabase.ui.util

import android.widget.ImageView
import com.bumptech.glide.load.model.GlideUrl
import com.twins.mymoviedatabase.ui.R

/**
 * Created by bukalapak on 11/20/17.
 */
object ImageLoader {

    fun load(view: ImageView,
             url: GlideUrl?,
             placeholderColor: Int?,
             placeholderDrawable: Int?) {
        view.setImageResource(R.drawable.hunger_games)
    }

}