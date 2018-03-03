package com.twins.mymoviedatabase.feature.movie

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.twins.mymoviedatabase.core.data.model.Movie
import com.twins.mymoviedatabase.core.netapi.Api
import com.twins.mymoviedatabase.core.netapi.response.ApiResponse
import com.twins.mymoviedatabase.core.netapi.service.MovieService
import com.twins.mymoviedatabase.core.viewmodel.BaseViewModel

/**
 * Created by Yolanda-PC on 11/02/2018.
 */
class MovieDetailViewModel(api: Api) : BaseViewModel(api) {

    private val movieService = api.service(MovieService::class.java)

    private val movieIdLiveData = MutableLiveData<Long>()

    val movieDetailData: LiveData<ApiResponse<Movie>> = Transformations.switchMap(movieIdLiveData) {
        movieService.getMovieDetail(it)
    }

    fun fetchMovieDetail(movieId: Long) {
        movieIdLiveData.value = movieId
    }

}