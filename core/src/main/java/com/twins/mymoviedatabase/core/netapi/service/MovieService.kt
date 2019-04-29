package com.twins.mymoviedatabase.core.netapi.service

import androidx.lifecycle.LiveData
import com.twins.mymoviedatabase.core.config.TmdbConstants
import com.twins.mymoviedatabase.core.data.model.Movie
import com.twins.mymoviedatabase.core.netapi.response.ApiResponse
import com.twins.mymoviedatabase.core.netapi.response.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by Ridwan Arvihafiz on 09/11/17.
 */
interface MovieService {

    @GET("/3/movie/{movie_id}?api_key=${TmdbConstants.API_KEY_3}")
    fun getMovieDetail(@Path("movie_id") id: Long): LiveData<ApiResponse<Movie>>

    @GET("/3/movie/upcoming?api_key=${TmdbConstants.API_KEY_3}")
    fun getUpcomingMovies(): LiveData<ApiResponse<MovieList>>

    @GET("/3/movie/upcoming?api_key=${TmdbConstants.API_KEY_3}")
    fun getUpcoming(@Query("page") page: Int): Call<MovieList>

    // TODO: uncomment all of these and use them
    /*@GET("/movie/{movie_id}/account_states")
    fun getAccountStates(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/account_states")
    fun getAlternativeTitles(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/changes")
    fun getMovieChanges(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/credits")
    fun getMovieCredits(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/images")
    fun getMovieImages(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/keywords")
    fun getMovieKeywords(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/release_dates")
    fun getMovieReleaseDates(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/videos")
    fun getMovieVideos(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/translations")
    fun getMovieTranslations(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/recommendations")
    fun getMovieRecommendations(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/similar")
    fun getSimilarMovies(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/reviews")
    fun getMovieReviews(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/{movie_id}/lists")
    fun getMovieLists(@Path("movie_id") movieID: Int): Call<Movie>

    @POST("/movie/{movie_id}/rating")
    fun getMovieRating(@Path("movie_id") movieID: Int): Call<Movie>

    @DELETE("/movie/{movie_id}/rating")
    fun deleteMovieRating(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/latest")
    fun getLatestMovies(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/now_playing")
    fun getNowPlayingMovies(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/popular")
    fun getPopularMovies(@Path("movie_id") movieID: Int): Call<Movie>

    @GET("/movie/top_rated")
    fun getTopRatedMovies(@Path("movie_id") movieID: Int): Call<Movie>
*/
}