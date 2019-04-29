package com.twins.mymoviedatabase.catalog.matcher

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.test.espresso.matcher.BoundedMatcher
import com.twins.mymoviedatabase.catalog.MovieRectangleCardActivity
import com.twins.mymoviedatabase.catalog.R
import com.twins.mymoviedatabase.ui.view.MovieRectangleCard
import org.hamcrest.Description
import org.hamcrest.Matcher

/**
 * Created by bukalapak on 11/18/17.
 */
object MovieRectangleCardMatcher {

    @JvmStatic
    fun withOriginalContents(): Matcher<View> {
        return object : BoundedMatcher<View, MovieRectangleCard>(MovieRectangleCard::class.java) {

            override fun matchesSafely(item: MovieRectangleCard?): Boolean {
                item?.let { view ->
                    val propertiesMatch = view.imageUrl == MovieRectangleCardActivity.POSTER &&
                            view.title == MovieRectangleCardActivity.TITLE &&
                            view.description == MovieRectangleCardActivity.DESCRIPTION &&
                            view.label1 == MovieRectangleCardActivity.LABEL1 &&
                            view.label2 == MovieRectangleCardActivity.LABEL2

                    val imageExist = view.findViewById<ImageView>(R.id.ivBig).drawable != null
                    val titleMatch = view.findViewById<TextView>(R.id.tvTitle).text.toString() == view.title
                    val descriptionMatch = view.findViewById<TextView>(R.id.tvDescription).text.toString() == view.description
                    val label1Match = view.findViewById<TextView>(R.id.tvLabel1).text.toString() == view.label1
                    val label2Match = view.findViewById<TextView>(R.id.tvLabel2).text.toString() == view.label2

                    return propertiesMatch && imageExist && titleMatch && descriptionMatch && label1Match && label2Match
                } ?: return false
            }

            override fun describeTo(description: Description?) {
                description?.appendText("with original contents of ${MovieRectangleCardActivity.TAG}")
            }


        }
    }

}