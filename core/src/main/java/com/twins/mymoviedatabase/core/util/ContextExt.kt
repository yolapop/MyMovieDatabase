package com.twins.mymoviedatabase.core.util

import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.widget.Toast

/**
 * Created by bukalapak on 10/2/17.
 */
fun Context.toastShort(msg: CharSequence?) {
    msg?.let {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

fun Context.toastLong(msg: CharSequence?) {
    msg?.let {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}

@ColorInt
fun Context.color(@ColorRes res: Int): Int {
    return ContextCompat.getColor(this, res)
}