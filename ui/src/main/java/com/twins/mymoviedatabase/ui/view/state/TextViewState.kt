package com.twins.mymoviedatabase.ui.view.state

import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.StyleRes
import android.view.Gravity
import com.twins.mymoviedatabase.ui.R

/**
 * A state for [android.widget.TextView] and its subclasses that will be bound via
 * [com.twins.mymoviedatabase.ui.view.binder.TextViewBinder]
 */
class TextViewState : ViewStateBase() {

    @StyleRes
    var style: Int = R.style.Body1

    var text: CharSequence? = null

    var textGravity = Gravity.START

    /**
     * Left, top, right, and bottom Drawables
     */
    var iconDrawables: Array<Drawable>? = null

    /**
     * Left, top, right, and bottom Drawable resources
     */
    @DrawableRes
    var iconResources: Array<Int>? = null

    /**
     * Left, top, right, and bottom Drawable tints
     */
    @ColorRes
    var iconTints: Array<Int>? = null

}