package com.twins.mymoviedatabase

import android.os.Bundle
import com.twins.mymoviedatabase.util.toastLong
import com.twins.mymoviedatabase.util.unwrap

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unwrap(prefs) {
            toastLong("PREF TIDAK NULL HORE")
        } otherwise {
            toastLong("TABLE FLIP")
        }

        toastLong("realm is " + realm)
    }
}