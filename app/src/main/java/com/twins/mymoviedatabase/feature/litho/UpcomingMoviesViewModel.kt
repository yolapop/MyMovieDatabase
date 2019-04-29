package com.twins.mymoviedatabase.feature.litho

import com.twins.mymoviedatabase.core.netapi.Api
import com.twins.mymoviedatabase.core.netapi.DataFetcher
import com.twins.mymoviedatabase.core.netapi.response.MovieList
import com.twins.mymoviedatabase.core.netapi.service.MovieService
import com.twins.mymoviedatabase.core.viewmodel.BaseViewModel

class UpcomingMoviesViewModel(api: Api) : BaseViewModel(api) {

    private val movieService = api.service(MovieService::class.java)

    val movieList = DataFetcher<Any?, MovieList> { movieService.getUpcomingMovies() }

}