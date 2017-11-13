package com.twins.mymoviedatabase.core.netapi.response

import com.google.gson.annotations.SerializedName

/**
 * Created by bukalapak on 10/29/17.
 */
open class BaseResponse {

    var success: Boolean = false

    @SerializedName("status_code")
    var statusCode: Int? = 0

    @SerializedName("status_message")
    var statusMessage: String? = null

    @SerializedName("error_message")
    var errorMessage: String? = null

}