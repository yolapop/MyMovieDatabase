package com.twins.mymoviedatabase.core.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by bukalapak on 11/5/17.
 */
open class Company(
        @PrimaryKey var id: Long = 0,
        var name: String? = null,
        var description: String? = null,
        var headquarters: String? = null,
        var homepage: String? = null,
        @SerializedName("logo_path")
        var logoPath: String? = null,
        @SerializedName("parent_company")
        var parentCompany: Company? = null
) : RealmObject()