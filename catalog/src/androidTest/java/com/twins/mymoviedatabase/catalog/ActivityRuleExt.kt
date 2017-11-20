package com.twins.mymoviedatabase.catalog

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule

/**
 * Created by bukalapak on 11/18/17.
 */
fun <T : Activity> ActivityTestRule<T>.rotateScreen() {
    val context = InstrumentationRegistry.getTargetContext()
    val orientation = context.resources.configuration.orientation

    val activity = this.activity
    activity.requestedOrientation = if (orientation == Configuration.ORIENTATION_PORTRAIT)
        ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    else
        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
}