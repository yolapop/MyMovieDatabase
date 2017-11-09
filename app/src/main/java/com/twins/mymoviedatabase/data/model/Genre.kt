package com.twins.mymoviedatabase.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by bukalapak on 11/5/17.
 */
open class Genre(
        @PrimaryKey var id: Long = 0,
        var name: String? = null
) : RealmObject()