package com.twins.mymoviedatabase.catalog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLaunch.setOnClickListener {
            startActivity(Intent(this, MovieRectangleCardActivity::class.java))
        }
    }
}
