package com.twins.mymoviedatabase

import android.annotation.SuppressLint
import android.content.SharedPreferences
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by bukalapak on 10/2/17.
 */
@SuppressLint("Registered")
open class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var prefs: Lazy<SharedPreferences>

}