package com.twins.mymoviedatabase

import android.content.SharedPreferences
import dagger.android.support.DaggerAppCompatActivity
import io.realm.Realm
import javax.inject.Inject

/**
 * Created by bukalapak on 10/2/17.
 */
open class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var prefs: SharedPreferences
    @Inject
    protected lateinit var realm: Realm

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

}