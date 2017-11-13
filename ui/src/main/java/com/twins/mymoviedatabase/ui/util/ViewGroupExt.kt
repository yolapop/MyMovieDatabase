package com.twins.mymoviedatabase.ui.util

import android.support.annotation.LayoutRes
import android.view.View
import android.view.ViewGroup

/**
 * Created by bukalapak on 11/8/17.
 */
fun ViewGroup.contentRes(@LayoutRes res: Int): View {
    return View.inflate(context, res, this)
}