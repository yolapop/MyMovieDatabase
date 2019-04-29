package com.twins.mymoviedatabase.ui.util

import android.os.Build
import android.widget.TextView
import androidx.annotation.StyleRes
import androidx.core.widget.TextViewCompat

/**
 * Set text appearance, more complete than Android default. This will set below properties:
 *     1. All text properties from style (e.g. textSize, textStyle, textAllCaps)
 *     2. Font
 *     3. Line spacing
 *     4. Letter spacing
 *     5. Background
 */
fun TextView.setTextStyle(@StyleRes style: Int) {
    TextViewCompat.setTextAppearance(this, style)
    TextViewUtils.setFontFromStyle(this, style)
    TextViewUtils.setLineSpacingExtraFromStyle(this, style)
    ViewUtils.setBackgroundFromStyle(this, style)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        TextViewUtils.setLetterSpacingFromStyle(this, style)
    }
}

fun TextView.resetTextStyle() {
    setAllCaps(false)
    setLineSpacing(0f, 1f)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        letterSpacing = 0f
    }
}