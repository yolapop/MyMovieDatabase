package com.twins.mymoviedatabase.ui.util

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import com.twins.mymoviedatabase.core.util.unwrap
import com.twins.mymoviedatabase.ui.R
import com.twins.mymoviedatabase.ui.view.state.ViewStateBase

/**
 * Created by Yolanda-PC on 16/12/2017.
 */
fun View.setBackground(res: Int?) {
    unwrap(res) {
        setBackgroundResource(it)
    } otherwise {
        background = null
    }
}

fun View.setPadding(frame: Frame?) {
    unwrap(frame) { (left, top, right, bottom) ->
        setPadding(left, top, right, bottom)
    } otherwise {
        setPadding(0, 0, 0, 0)
    }
}

fun View.setMargins(frame: Frame?) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        val llp = layoutParams as ViewGroup.MarginLayoutParams
        llp.setMargins(frame)
    }
}

fun ViewGroup.MarginLayoutParams.setMargins(frame: Frame?) {
    unwrap(frame) { (left, top, right, bottom) ->
        setMargins(left, top, right, bottom)
    } otherwise {
        setMargins(0, 0, 0, 0)
    }
}

/**
 * Programmatically set foreground with [android.R.attr.selectableItemBackground].
 * For now only works for [FrameLayout]
 */
fun View.setSelectableForeground(yes: Boolean) {
    if (this is FrameLayout) {
        if (yes) {
            val attrs = intArrayOf(R.attr.selectableItemBackground)
            val typedArray = context.obtainStyledAttributes(attrs)
            val backgroundResource = typedArray.getResourceId(0, 0)
            (this).foreground = ContextCompat.getDrawable(context, backgroundResource)
            typedArray.recycle()
        } else {
            (this).foreground = null
        }
    }
}

fun View.setListPreferredItemHeight(yes: Boolean, default: Int? = null) {
    val _minHeight: Int
    _minHeight = if (yes || default == ViewStateBase.MIN_HEIGHT_LIST) {
        val value = TypedValue()
        context.theme.resolveAttribute(android.R.attr.listPreferredItemHeight, value, true)
        val metrics = DisplayMetrics()
        (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager)
                .defaultDisplay.getMetrics(metrics)
        val ret = value.getDimension(metrics)
        ret.toInt()
    } else {
        0
    }

    if (this is ConstraintLayout) {
        this.minHeight = _minHeight
    } else {
        this.minimumHeight = _minHeight
    }
}

fun View.wrapInFrameLayout(): FrameLayout = FrameLayout(context).also { it.addView(this) }