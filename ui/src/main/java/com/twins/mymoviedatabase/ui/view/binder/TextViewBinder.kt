package com.twins.mymoviedatabase.ui.view.binder

import android.graphics.drawable.Drawable
import android.widget.TextView
import com.twins.mymoviedatabase.core.util.drawable
import com.twins.mymoviedatabase.core.util.parseHtml
import com.twins.mymoviedatabase.ui.util.setBackground
import com.twins.mymoviedatabase.ui.util.setListPreferredItemHeight
import com.twins.mymoviedatabase.ui.util.setMargins
import com.twins.mymoviedatabase.ui.util.setPadding
import com.twins.mymoviedatabase.ui.util.setTextStyle
import com.twins.mymoviedatabase.ui.view.state.TextViewState
import com.twins.mymoviedatabase.ui.view.state.ViewStateBase

/**
 * Bind [com.twins.mymoviedatabase.ui.view.state.TextViewState] to [android.widget.TextView]
 */
object TextViewBinder : ViewBinderBase<TextView, TextViewState>() {

    private fun bindIcons(view: TextView, state: TextViewState) = with(view) {
        var iconLeft: Drawable? = null
        var iconTop: Drawable? = null
        var iconRight: Drawable? = null
        var iconBottom: Drawable? = null

        state.iconRes?.let {
            iconLeft = context.drawable(it.getOrNull(0))
            iconTop = context.drawable(it.getOrNull(1))
            iconRight = context.drawable(it.getOrNull(2))
            iconBottom = context.drawable(it.getOrNull(3))
        } ?: state.iconDrawables?.let {
            iconLeft = it.getOrNull(0)
            iconTop = it.getOrNull(1)
            iconRight = it.getOrNull(2)
            iconBottom = it.getOrNull(3)
        }

        iconLeft = context.drawable(iconLeft, state.iconTints?.getOrNull(0))
        iconTop = context.drawable(iconTop, state.iconTints?.getOrNull(1))
        iconRight = context.drawable(iconRight, state.iconTints?.getOrNull(2))
        iconBottom = context.drawable(iconBottom, state.iconTints?.getOrNull(3))

        setCompoundDrawablesWithIntrinsicBounds(iconLeft, iconTop, iconRight, iconBottom)
    }

    private fun bindText(view: TextView, state: TextViewState) = with(view) {
        val _text = state.text
        text = (_text as? String)?.parseHtml() ?: _text
    }

    override fun bind(view: TextView, state: TextViewState) = with(view) {
        setBackground(state.background)
        setTextStyle(state.style)
        setPadding(state.padding)
        isEnabled = state.enabled
        gravity = state.textGravity
        bindText(this, state)
        bindIcons(this, state)
        setListPreferredItemHeight(state.minHeight == ViewStateBase.MIN_HEIGHT_LIST, state.minHeight)
        setMargins(state.margin)
        requestLayout()
    }

}