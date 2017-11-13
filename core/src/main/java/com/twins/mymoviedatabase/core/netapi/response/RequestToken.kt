package com.twins.mymoviedatabase.core.netapi.response

import com.google.gson.annotations.SerializedName

/**
 * Created by bukalapak on 10/29/17.
 */
data class RequestToken(
        @SerializedName("request_token")
        var token: String
) : BaseResponse()