package com.twins.mymoviedatabase.ui.util

import android.support.annotation.StyleRes
import android.view.View

/**
 * Created by Yolanda-PC on 17/12/2017.
 */
object ViewUtils {

    fun setBackgroundFromStyle(view: View, @StyleRes style: Int) {
        // The attributes you want retrieved
        val attrs = intArrayOf(android.R.attr.background)
        val ta = view.context.obtainStyledAttributes(style, attrs)
        try {
            val res = ta.getResourceId(0, 0)
            if (res != 0) {
                view.setBackgroundResource(res)
            }
        } finally {
            ta.recycle()
        }
    }

}