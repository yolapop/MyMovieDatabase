package com.twins.mymoviedatabase.ui.util

import android.annotation.TargetApi
import android.graphics.Typeface
import android.os.Build
import android.widget.TextView
import androidx.annotation.StyleRes

/**
 * Created by Yolanda-PC on 17/12/2017.
 */
object TextViewUtils {

    @JvmStatic
    fun setLineSpacingExtraFromStyle(tv: TextView, @StyleRes style: Int) {
        // The attributes you want retrieved
        val attrs = intArrayOf(android.R.attr.lineSpacingExtra)
        val ta = tv.context.obtainStyledAttributes(style, attrs)
        try {
            tv.setLineSpacing(ta.getDimensionPixelSize(0, 0).toFloat(), 1f)
        } finally {
            ta.recycle()
        }
    }

    @JvmStatic
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun setLetterSpacingFromStyle(tv: TextView, @StyleRes style: Int) {
        // The attributes you want retrieved
        val attrs = intArrayOf(android.R.attr.letterSpacing)
        val ta = tv.context.obtainStyledAttributes(style, attrs)
        try {
            tv.letterSpacing = ta.getFloat(0, 0f)
        } finally {
            ta.recycle()
        }
    }

    @JvmStatic
    fun setFontFromStyle(tv: TextView, @StyleRes style: Int) {
        // The attributes you want retrieved
        val attrs = intArrayOf(android.R.attr.fontFamily)
        val ta = tv.context.obtainStyledAttributes(style, attrs)
        try {
            ta.getString(0)?.let {
                if (!it.isBlank()) {
                    tv.typeface = Typeface.create(it, tv.typeface.style)
                }
            }
        } finally {
            ta.recycle()
        }
    }

}