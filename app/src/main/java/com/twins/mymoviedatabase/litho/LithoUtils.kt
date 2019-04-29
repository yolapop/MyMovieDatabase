package com.twins.mymoviedatabase.litho

import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.soloader.SoLoader

/**
 * Created by Yolanda-PC on 02/04/2018.
 */
object LithoUtils {

    fun setupLitho(context: Context) {
        Fresco.initialize(context)
        SoLoader.init(context, false)
    }

}