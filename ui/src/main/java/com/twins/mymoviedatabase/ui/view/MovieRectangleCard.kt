package com.twins.mymoviedatabase.ui.view

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import com.twins.mymoviedatabase.core.util.unwrap
import com.twins.mymoviedatabase.ui.R
import com.twins.mymoviedatabase.ui.glide.ImageLoader
import com.twins.mymoviedatabase.ui.util.ViewStateDelegate
import com.twins.mymoviedatabase.ui.util.contentRes
import com.twins.mymoviedatabase.ui.util.setImageUrl
import kotlinx.android.synthetic.main.movie_rectangle_card.view.*
import javax.inject.Inject

/**
 * Created by bukalapak on 11/8/17.
 */
@Suppress("ConvertSecondaryConstructorToPrimary")
class MovieRectangleCard : KeepConstraintLayout {

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
            super(context, attrs, defStyleAttr) {
        contentRes(R.layout.movie_rectangle_card)
        initAttr(attrs)
    }

    /**
     * Should we inject our custom views? Personally I think it's good when a View doesn't need to
     * be injected but I need to mock Glide/ImageLoader
     */
    @Inject
    lateinit var imageLoader: ImageLoader

    var imageDrawable: Int? by ViewStateDelegate<Int?>(null) {
        unwrap(it) {
            imageUrl = null
            ivBig.setImageResource(it)
        } otherwise {
            ivBig.setImageDrawable(null)
        }
    }

    var imageUrl: String? by ViewStateDelegate<String?>(null) {
        if (it != null) imageDrawable = null
        ivBig.setImageUrl(url = it, placeholderColor = R.color.md_grey_400)
    }

    var title by ViewStateDelegate<CharSequence?>(null) {
        tvTitle.text = it
    }

    var description by ViewStateDelegate<CharSequence?>(null) {
        tvDescription.text = it
    }

    var label1 by ViewStateDelegate<CharSequence?>(null) {
        tvLabel1.text = it
    }

    var label2 by ViewStateDelegate<CharSequence?>(null) {
        tvLabel2.text = it
    }

    private fun initAttr(attrs: AttributeSet?) {
        if (attrs == null) return

        val a = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.MovieRectangleCard,
                0, 0)

        try {
            imageUrl = a.getString(R.styleable.MovieRectangleCard_mrc_imageUrl)
            title = a.getString(R.styleable.MovieRectangleCard_mrc_title)
            description = a.getString(R.styleable.MovieRectangleCard_mrc_description)
            label1 = a.getString(R.styleable.MovieRectangleCard_mrc_label1)
            label2 = a.getString(R.styleable.MovieRectangleCard_mrc_label2)
        } finally {
            a.recycle()
        }

    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        super.onRestoreInstanceState(state)
        imageUrl = imageUrl
        title = title
        description = description
        label1 = label1
        label2 = label2
    }

}