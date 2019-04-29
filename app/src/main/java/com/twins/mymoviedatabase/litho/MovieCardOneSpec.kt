package com.twins.mymoviedatabase.litho

import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.litho.ClickEvent
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.Row
import com.facebook.litho.StateValue
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.OnUpdateState
import com.facebook.litho.annotations.Prop
import com.facebook.litho.annotations.State
import com.facebook.litho.fresco.FrescoImage
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaEdge
import com.facebook.yoga.YogaJustify
import com.facebook.yoga.YogaPositionType
import com.twins.mymoviedatabase.R
import com.twins.mymoviedatabase.core.netapi.ImageUtils
import com.twins.mymoviedatabase.util.drawable

/**
 *    +-------------------------+
 *    |                         |
 *    |   +-----------------+   |
 *    |   |                 |   |
 *    |   |                 |   |
 *    |   |                 |   |
 *    |   |     Poster      |   |
 *    |   |                 |   |
 *    |   |                 |   |
 *    |   |                 |   |
 *    |   |                 |   |
 *    |   |                 |   |
 *    |   +-----------------+   |
 *    |   Here lies the movie   |
 *    |   title, 2 lines max    |
 *    |                         |
 *    |   02:30             R   |
 *    |                         |
 *    +-------------------------+
 *
 * All the Litho view specs have to be put in this module due to a weird bug where if I put
 * the specs in UI module, the generated classes won't be accessible in the APP module.
 *
 * TODO: future me, solve this
 */
@LayoutSpec
class MovieCardOneSpec {

    companion object {

        @JvmStatic
        @OnCreateLayout
        fun onCreateLayout(context: ComponentContext, @Prop movie: Movie, @State isFavorite: Boolean): Component {
            val imageController = Fresco.newDraweeControllerBuilder()
                    .setUri("http://image.tmdb.org/t/p/w342" + movie.posterPath)
                    .build()
            val posterComponent = FrescoImage.create(context)
                    .controller(imageController)
                    .widthDip(100f)
                    .imageAspectRatio(ImageUtils.POSTER_RATIO)
            val iconTint = if (isFavorite) R.color.md_pink_400 else R.color.md_grey_400
            val favIconComponent = Image.create(context)
                    .drawable(drawable(R.drawable.ic_favorite_black_24dp,
                            tint = iconTint))
                    .positionType(YogaPositionType.ABSOLUTE)
                    .positionDip(YogaEdge.RIGHT, 0f)
                    .clickHandler(MovieCardOne.onFavoriteClicked(context))
            val titleComponent = Text.create(context)
                    .text(movie.title)
                    .maxLines(2)
                    .marginDip(YogaEdge.TOP, 8f)
            val runtimeComponent = Text.create(context)
                    .text(movie.runtime?.toString())
            val voteComponent = Text.create(context)
                    .text(movie.voteAverage?.toString())
            return Column.create(context)
                    .widthDip(100f)
                    .child(posterComponent)
                    .child(favIconComponent)
                    .child(titleComponent)
                    .child(
                            Row.create(context)
                                    .justifyContent(YogaJustify.SPACE_BETWEEN)
                                    .child(runtimeComponent)
                                    .child(voteComponent)

                    )
                    .build()
        }

        @JvmStatic
        @OnUpdateState
        fun updateFavoriteState(isFavorite: StateValue<Boolean>) {
            isFavorite.set(isFavorite.get()?.not() ?: false)
        }

        @JvmStatic
        @OnEvent(ClickEvent::class)
        fun onFavoriteClicked(context: ComponentContext) {
            MovieCardOne.updateFavoriteStateAsync(context)
        }
    }
}