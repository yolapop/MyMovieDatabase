package com.twins.mymoviedatabase.ui.view.binder

import android.view.View
import android.widget.FrameLayout
import com.twins.mymoviedatabase.ui.util.firstChild
import com.twins.mymoviedatabase.ui.util.setSelectableForeground
import com.twins.mymoviedatabase.ui.view.state.ViewStateBase

/**
 * The purpose of ViewBinder is solely to make it easy for us to set View properties as RecyclerView
 * items. It doesn't replace the traditional custom View coding.
 * For example, [com.twins.mymoviedatabase.ui.view.MovieRectangleCard] is written as is,
 * nothing fancy, and when you need to bind it in a [com.twins.mymoviedatabase.ui.item.ViewItem]
 * you can make a MovieRectangleCardBinder and MovieRectangleCardState to easily bind the state to
 * the view.
 */
abstract class ViewBinderBase<in V : View, in S : ViewStateBase> {

    fun bind(view: FrameLayout, state: S) {
        view.setSelectableForeground(state.useSelectableForeground)
        bind(view.firstChild<V>(), state)
    }

    open fun bind(view: V, state: S) {
        if (view is FrameLayout) view.setSelectableForeground(state.useSelectableForeground)
    }

}