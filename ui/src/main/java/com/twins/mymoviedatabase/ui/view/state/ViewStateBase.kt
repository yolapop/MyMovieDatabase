package com.twins.mymoviedatabase.ui.view.state

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.annotation.Px
import com.twins.mymoviedatabase.ui.util.Frame

/**
 * Created by Yolanda-PC on 16/12/2017.
 */
open class ViewStateBase {

    @DrawableRes
    var background: Int? = null

    var padding: Frame? = null

    var enabled = true

    /**
     * This is a flag that indicates this custom view should have a foreground ripple.
     * You can choose to not implementing it.
     */
    var useSelectableForeground = false

    var margin: Frame? = null

    @Px
    var minHeight: Int = 0

    /**
     * Indicating that this View should have layout_width = wrap_content
     */
    var wrapWidth = false

    /**
     * Indicating that this View should have layout_height = wrap_content
     */
    var wrapHeight = true

    fun getMarginLayoutParam(): ViewGroup.MarginLayoutParams {
        return ViewGroup.MarginLayoutParams(if (wrapWidth)
            ViewGroup.LayoutParams.WRAP_CONTENT else ViewGroup.LayoutParams.MATCH_PARENT,
                if (wrapHeight) ViewGroup.LayoutParams.WRAP_CONTENT else ViewGroup.LayoutParams.MATCH_PARENT)
    }

    fun getLinearLayoutParam(): LinearLayout.LayoutParams {
        return LinearLayout.LayoutParams(if (wrapWidth)
            ViewGroup.LayoutParams.WRAP_CONTENT else ViewGroup.LayoutParams.MATCH_PARENT,
                if (wrapHeight) ViewGroup.LayoutParams.WRAP_CONTENT else ViewGroup.LayoutParams.MATCH_PARENT)
    }

    companion object {
        const val MIN_HEIGHT_LIST = Int.MAX_VALUE
        const val MAX_LINES_UNLIMITED = Int.MAX_VALUE
    }

}
