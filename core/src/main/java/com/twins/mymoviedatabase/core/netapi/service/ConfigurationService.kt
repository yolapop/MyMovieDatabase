package com.twins.mymoviedatabase.core.netapi.service

import android.arch.lifecycle.LiveData
import com.twins.mymoviedatabase.core.config.TmdbConstants
import com.twins.mymoviedatabase.core.data.model.Configuration
import com.twins.mymoviedatabase.core.netapi.response.ApiResponse
import retrofit2.http.GET

/**
 * Created by Yolanda-PC on 11/03/2018.
 */
interface ConfigurationService {

    @GET("/3/configuration?api_key=${TmdbConstants.API_KEY_3}")
    fun getConfiguration(): LiveData<ApiResponse<Configuration>>

}