package com.twins.mymoviedatabase.ui.util

/**
 * Created by Yolanda-PC on 16/12/2017.
 */
data class Frame(var left: Int = 0, var top: Int = 0, var right: Int = 0, var bottom: Int = 0) {
    constructor(horizontal: Int = 0, vertical: Int = 0) : this(left = horizontal, top = vertical, right = horizontal, bottom = vertical)
    constructor(all: Int = 0) : this(left = all, top = all, right = all, bottom = all)
}