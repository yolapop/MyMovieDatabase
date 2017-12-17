package com.twins.mymoviedatabase.core.util

import android.os.Build
import android.text.Html
import android.text.Spanned

/**
 * Created by Yolanda-PC on 17/12/2017.
 */
fun String.parseHtml() : Spanned {
    return if (Build.VERSION.SDK_INT >= 24) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(this)
    }
}