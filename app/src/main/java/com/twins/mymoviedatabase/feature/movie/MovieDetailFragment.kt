package com.twins.mymoviedatabase.feature.movie

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import com.twins.mymoviedatabase.BaseFragment

/**
 * Created by Yolanda-PC on 11/02/2018.
 */
class MovieDetailFragment : BaseFragment() {

    override var title: CharSequence? = "Movie Detail"

    private val viewModel by lazy { getViewModel(MovieDetailViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchMovieDetail(23)
    }

    override fun observeData() {
        // TODO: make some UI
        viewModel.movieDetailData.observe(this, Observer {
            Log.v("yolapop", "success: ${it?.success}, code ${it?.code}")
        })
    }

}