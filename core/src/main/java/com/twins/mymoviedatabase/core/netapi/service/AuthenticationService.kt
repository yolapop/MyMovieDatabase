package com.twins.mymoviedatabase.core.netapi.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by bukalapak on 10/27/17.
 */
interface AuthenticationService {

    @POST("/4/auth/request_token")
    fun createRequestToken(@Body param: com.twins.mymoviedatabase.core.netapi.request.RequestToken): Call<com.twins.mymoviedatabase.core.netapi.response.RequestToken>

}