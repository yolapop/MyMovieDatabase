package com.twins.mymoviedatabase.util

import android.content.Context
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