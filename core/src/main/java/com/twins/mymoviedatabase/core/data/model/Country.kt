package com.twins.mymoviedatabase.core.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by bukalapak on 11/5/17.
 */
open class Country(
        @PrimaryKey
        @SerializedName("iso_3166_1")
        var iso: String = "",
        var name: String? = null
) : RealmObject()