package com.twins.mymoviedatabase.litho

import com.facebook.litho.annotations.Event

@Event
class MoviesEvent {
    @JvmField
    var movies: List<Movie> = emptyList()
}