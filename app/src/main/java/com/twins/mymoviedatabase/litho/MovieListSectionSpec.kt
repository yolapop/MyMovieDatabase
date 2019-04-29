package com.twins.mymoviedatabase.litho

import android.widget.Toast
import com.facebook.litho.StateValue
import com.facebook.litho.annotations.FromEvent
import com.facebook.litho.annotations.OnCreateInitialState
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.OnUpdateState
import com.facebook.litho.annotations.Param
import com.facebook.litho.annotations.Prop
import com.facebook.litho.annotations.State
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.LoadingEvent
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.SectionLifecycle
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnBindService
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.annotations.OnCreateService
import com.facebook.litho.sections.annotations.OnUnbindService
import com.facebook.litho.sections.annotations.OnViewportChanged
import com.facebook.litho.sections.common.DataDiffSection
import com.facebook.litho.sections.common.RenderEvent
import com.facebook.litho.widget.ComponentRenderInfo
import com.facebook.litho.widget.RenderInfo

@GroupSectionSpec
object MovieListSectionSpec {

    @OnCreateInitialState
    fun onCreateInitialState(context: SectionContext,
                             movies: StateValue<List<Movie>>,
                             page: StateValue<Int>,
                             isFetching: StateValue<Boolean>) {
        page.set(0)
        isFetching.set(false)
        movies.set((1..5).map { Movie(id = it.toLong(),
                title = "The Lord of the Rings $it",
                posterPath = "/1l3WpoF7TX9pOprX4XepCXjQXUV.jpg",
                runtime = 132,
                voteAverage = 6.5) })
    }

    @OnCreateChildren
    fun onCreateChildren(context: SectionContext, @State movies: List<Movie>): Children {
        val childrenBuilder = Children.create()
                .child(
                        DataDiffSection.create<Movie>(context)
                                .data(movies)
                                .renderEventHandler(MovieListSection.onRender(context))
                )
        return childrenBuilder.build()
    }

    @OnEvent(RenderEvent::class)
    fun onRender(context: SectionContext, @FromEvent model: Movie): RenderInfo {
        val movieComponent = MovieCardOne.create(context).movie(model).build()
        return ComponentRenderInfo.create()
                .component(movieComponent).build()
    }

    /**
     * This will be initiated when this component is first created
     */
    @OnCreateService
    fun onCreateService(context: SectionContext, @Prop service: MovieService): UpcomingMoviesService {
        return UpcomingMoviesService(service)
    }

    @OnBindService
    fun onBindService(context: SectionContext, service: UpcomingMoviesService) {
        service.registerLoadingEvent(MovieListSection.onDataLoaded(context))
    }

    @OnUnbindService
    fun onUnbindService(context: SectionContext, service: UpcomingMoviesService) {
        service.unregisterLoadingEvent()
    }

    @OnEvent(MoviesEvent::class)
    fun onDataLoaded(context: SectionContext, @FromEvent movies: List<Movie>) {
        MovieListSection.onUpdateData(context, movies)
        SectionLifecycle.dispatchLoadingEvent(context, false, LoadingEvent.LoadingState.SUCCEEDED, null)
    }

    @OnUpdateState
    fun onUpdateData(movies: StateValue<List<Movie>>,
                     page: StateValue<Int>,
                     isFetching: StateValue<Boolean>,
                     @Param newMovies: List<Movie>) {
        isFetching.set(false)
        val list = movies.get() ?: emptyList()
        movies.set(list + newMovies)
    }

    @OnUpdateState
    fun setFetching(isFetching: StateValue<Boolean>,
                    page: StateValue<Int>,
                    @Param fetching: Boolean,
                    @Param fetchPage: Int) {
        isFetching.set(fetching)
        page.set(fetchPage)
    }

    @OnViewportChanged
    fun onViewportChanged(context: SectionContext,
                          firstVisiblePosition: Int,
                          lastVisiblePosition: Int,
                          firstFullyVisibleIndex: Int,
                          lastFullyVisibleIndex: Int,
                          totalCount: Int,
                          service: UpcomingMoviesService,
                          @State movies: List<Movie>,
                          @State page: Int,
                          @State isFetching: Boolean) {
        if (lastVisiblePosition == movies.size - 1 && !isFetching) {
            Toast.makeText(context.androidContext, "Fetch page ${page + 1}", Toast.LENGTH_SHORT).show()
            MovieListSection.setFetching(context, true, page + 1)
            service.fetch(page + 1)
        }
    }
}