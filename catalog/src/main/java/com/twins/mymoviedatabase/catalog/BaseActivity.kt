package com.twins.mymoviedatabase.catalog

import android.annotation.SuppressLint
import android.os.Bundle
import dagger.android.DaggerActivity

/**
 * Created by bukalapak on 11/21/17.
 */
@SuppressLint("Registered")
open class BaseActivity : DaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}