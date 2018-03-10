package com.twins.mymoviedatabase.feature.movie

import com.twins.mymoviedatabase.core.data.model.Movie
import com.twins.mymoviedatabase.core.netapi.Api
import com.twins.mymoviedatabase.core.netapi.DataFetcher
import com.twins.mymoviedatabase.core.netapi.service.MovieService
import com.twins.mymoviedatabase.core.viewmodel.BaseViewModel

/**
 * Created by Yolanda-PC on 11/02/2018.
 */
class MovieDetailViewModel(api: Api) : BaseViewModel(api) {

    private val movieService = api.service(MovieService::class.java)

    val movieDetail = DataFetcher<Long, Movie> { id -> movieService.getMovieDetail(id) }

}