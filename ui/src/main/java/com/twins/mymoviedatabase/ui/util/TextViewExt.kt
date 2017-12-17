package com.twins.mymoviedatabase.ui.util

import android.os.Build
import android.support.annotation.StyleRes
import android.support.v4.widget.TextViewCompat
import android.widget.TextView

/**
 * Set text appearance, more complete than Android default
 */
fun TextView.setMTextAppearance(@StyleRes style: Int) {
    TextViewCompat.setTextAppearance(this, style)
    TextViewUtils.setFontFromStyle(this, style)
    TextViewUtils.setLineSpacingExtraFromStyle(this, style)
    ViewUtils.setBackgroundFromStyle(this, style)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        TextViewUtils.setLetterSpacingFromStyle(this, style)
    }
}

fun TextView.resetTextAppearance() {
    setAllCaps(false)
    setLineSpacing(0f, 1f)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        letterSpacing = 0f
    }
}