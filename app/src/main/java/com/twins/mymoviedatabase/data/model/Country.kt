package com.twins.mymoviedatabase.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by bukalapak on 11/5/17.
 */
data class Country(@SerializedName("iso_3166_1") var iso: String, var name: String? = null)