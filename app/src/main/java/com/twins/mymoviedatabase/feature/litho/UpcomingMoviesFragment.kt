package com.twins.mymoviedatabase.feature.litho

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.twins.mymoviedatabase.BaseFragment
import com.twins.mymoviedatabase.litho.MovieListSection
import com.twins.mymoviedatabase.litho.MovieService

class UpcomingMoviesFragment : BaseFragment() {

    override var title: CharSequence? = "Movie List"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val c = ComponentContext(context)
        val section = MovieListSection.create(SectionContext(context))
                .service(api.service(MovieService::class.java))
                .build()
        val component = RecyclerCollectionComponent.create(c)
                .section(section)
                .widthPercent(100f)
                .heightPercent(100f)
                .disablePTR(true)
                .build()
        return LithoView.create(c, component)
    }

}