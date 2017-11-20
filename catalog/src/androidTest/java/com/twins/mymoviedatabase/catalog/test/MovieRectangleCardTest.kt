package com.twins.mymoviedatabase.catalog.test

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.twins.mymoviedatabase.catalog.MovieRectangleCardActivity
import com.twins.mymoviedatabase.catalog.R
import com.twins.mymoviedatabase.catalog.matcher.MovieRectangleCardMatcher
import com.twins.mymoviedatabase.catalog.rotateScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by bukalapak on 11/15/17.
 */
@SmallTest
@RunWith(AndroidJUnit4::class)
class MovieRectangleCardTest {

    @Rule @JvmField
    val activityRule = ActivityTestRule(MovieRectangleCardActivity::class.java)

    @Before

    @Test
    fun movieRectangleCard() {
        onView(withId(R.id.movieRectangleCard))
                .check(ViewAssertions.matches(MovieRectangleCardMatcher.withOriginalContents()))
        activityRule.rotateScreen()
        onView(withId(R.id.movieRectangleCard))
                .check(ViewAssertions.matches(MovieRectangleCardMatcher.withOriginalContents()))
    }

}