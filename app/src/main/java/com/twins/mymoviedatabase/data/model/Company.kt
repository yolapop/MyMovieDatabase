package com.twins.mymoviedatabase.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by bukalapak on 11/5/17.
 */
data class Company(
        var id: Long,
        var name: String? = null,
        var description: String? = null,
        var headquarters: String? = null,
        var homepage: String? = null,
        @SerializedName("logo_path")
        var logoPath: String? = null,
        @SerializedName("parent_company")
        var parentCompany: Company? = null
)