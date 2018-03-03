package com.twins.mymoviedatabase.core.netapi.response

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import java.io.IOException

/**
 * Created by Yolanda-PC on 03/03/2018.
 */
class ApiResponse<T> {

    val success: Boolean get() = code in 200..299

    /**
     * The HTTP response code
     */
    @SerializedName("status_code")
    var code: Int = 0

    @SerializedName("status_message")
    var statusMessage: String? = null

    @SerializedName("error_message")
    var errorMessage: String? = null

    var body: T? = null

    constructor(response: Response<T>) {
        code = response.code()
        if (response.isSuccessful) {
            body = response.body()
            errorMessage = null
        } else {
            var message: String? = null
            response.errorBody()?.let {
                try {
                    message = it.string()
                } catch (e: IOException) {
                    // error while parsing the error message, do nothing
                }
            }
            if (message.isNullOrBlank()) message = response.message()
            errorMessage = message
            body = null
        }
    }

    constructor(error: Throwable) {
        code = 500
        body = null
        errorMessage = error.message
    }

}