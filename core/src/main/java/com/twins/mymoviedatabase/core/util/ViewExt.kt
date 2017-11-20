package com.twins.mymoviedatabase.core.util

import android.app.Activity
import android.content.ContextWrapper
import android.view.View

/**
 * Created by bukalapak on 11/20/17.
 *
 * This hack is needed for us to be able to inject our custom views
 * @see <a href="https://gist.github.com/ronshapiro/af99799fe9dd7ec412f2d4e45b843370">Github Gist</a>
 */
fun View.getActivity(): Activity {
    var context = context
    while (context is ContextWrapper) {
        if (context is Activity) {
            return context
        }
        context = context.baseContext
    }
    throw IllegalStateException("Context does not stem from an Activity: " + context)
}