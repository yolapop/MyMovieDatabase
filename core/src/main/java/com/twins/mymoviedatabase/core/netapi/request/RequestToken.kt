package com.twins.mymoviedatabase.core.netapi.request

import com.google.gson.annotations.SerializedName

/**
 * Created by bukalapak on 11/2/17.
 */
data class RequestToken(@SerializedName("redirect_to") var redirectTo: String)