package com.twins.mymoviedatabase.ui.util

import android.view.View
import android.view.ViewGroup

/**
 * Created by Yolanda-PC on 01/04/2018.
 */
@Suppress("UNCHECKED_CAST")
fun <T : View> ViewGroup.firstChild(): T= getChildAt(0) as T