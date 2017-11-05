package com.twins.mymoviedatabase.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by bukalapak on 11/5/17.
 */
data class Language(@SerializedName("iso_639_1") var iso: String, var name: String? = null)