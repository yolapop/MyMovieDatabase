package com.twins.mymoviedatabase.catalog

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_rectangle_card.*

/**
 * Created by bukalapak on 11/16/17.
 */
class MovieRectangleCardActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rectangle_card)

        if (savedInstanceState == null) {
            movieRectangleCard.apply {
                imageUrl = POSTER
                title = TITLE
                description = DESCRIPTION
                label1 = LABEL1
                label2 = LABEL2
            }
        }
    }

    companion object {
        val TAG = MovieRectangleCardActivity::class.java.simpleName
        const val TITLE = "The Hunger Games"
        const val POSTER = "https://images-na.ssl-images-amazon.com/images/M/MV5BMjA4NDg3NzYxMF5BMl5BanBnXkFtZTcwNTgyNzkyNw@@._V1_SY1000_CR0,0,674,1000_AL_.jpg"
        const val DESCRIPTION = "Katniss Everdeen voluntarily takes her younger sister's place in the Hunger Games: a televised competition in which two teenagers from each of the twelve Districts of Panem are chosen at random to fight to the death."
        const val LABEL1 = "PG-13"
        const val LABEL2 = "TV-14"
    }

}