package com.twins.mymoviedatabase

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.widget.Toast
import javax.inject.Inject




class MainActivity : AppCompatActivity() {


    @Inject lateinit var prefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyMovieDatabaseApplication).component.inject(this)

        if (prefs == null) {
            makeToastLong(baseContext,"TABLE FLIP")

        } else {
            makeToastLong(baseContext,"PREF TIDAK NULL HORE")
        }

    }
}


fun makeToastLong(context: Context, str: String) {
    Toast.makeText(context,str, Toast.LENGTH_LONG).show()
}