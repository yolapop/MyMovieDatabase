package com.twins.mymoviedatabase.litho

import com.facebook.litho.annotations.FromEvent
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.widget.ComponentRenderInfo
import com.facebook.litho.widget.RenderInfo

//@GroupSectionSpec
class UpcomingMoviesGroupSpec {

    companion object {

        /*@JvmStatic
        @OnCreateInitialState
        fun createInitState(c: SectionContext, movies: StateValue<List<Movie>>) {
            movies.set(listOf(Movie(id = 1, title = "skdfjdhskdj")))
        }*/

        /*@JvmStatic
        @OnUpdateState
        fun onUpdateMovies(movies: StateValue<List<Movie>>, @Param newValue: List<Movie>) {
            movies.set(newValue)
        }*/

        /*@JvmStatic
        @OnCreateChildren
        fun onCreateChildren(c: SectionContext, @State movies: List<Movie>?): Children {
            return Children.create()
                    .child(
                            DataDiffSection.create<Movie>(c)
                                    .data(movies)
                                    .renderEventHandler(UpcomingMoviesGroup.onRender(c))
                    )
                    .build()
        }*/

        @JvmStatic
        //@OnEvent(RenderEvent::class)
        fun onRender(c: SectionContext, @FromEvent model: Movie): RenderInfo {
            val movieComponent = MovieCardOne.create(c).movie(model).build()
            return ComponentRenderInfo.create()
                    .component(movieComponent).build()
        }

    }

}