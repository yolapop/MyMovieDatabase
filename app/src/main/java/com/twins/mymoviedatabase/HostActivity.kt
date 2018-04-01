package com.twins.mymoviedatabase

import android.os.Bundle
import com.twins.mymoviedatabase.feature.movie.MovieDetailFragment
import kotlinx.android.synthetic.main.activity_main.*

class HostActivity : BaseActivity() {

    var fragment: BaseFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            // TODO: make MainActivity to host initial fragment
            fragment = MovieDetailFragment()

            fragment?.let {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.container, it)
                transaction.commit()
            }
        }

    }
}