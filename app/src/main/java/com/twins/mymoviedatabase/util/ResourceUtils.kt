package com.twins.mymoviedatabase.util

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.support.annotation.*
import com.twins.mymoviedatabase.App
import com.twins.mymoviedatabase.core.util.*

/**
 * Global functions that wrap extension functions of Context.
 * See for example: [com.twins.mymoviedatabase.core.util.drawable]
 */

val Int.dp get() = App.INSTANCE.dpToPx(this.toFloat())

val Float.dp get() = App.INSTANCE.dpToPx(this)

fun drawable(@DrawableRes res: Int?, @ColorRes tint: Int? = null): Drawable? =
        App.INSTANCE.drawable(res, tint)

fun drawable(d: Drawable?, @ColorRes tint: Int? = null): Drawable? =
        App.INSTANCE.drawable(d, tint)

fun resizeDrawable(@DrawableRes d: Int?, @Px width: Int, @Px height: Int): Drawable? =
        App.INSTANCE.resizeDrawable(d, width, height)

fun resizeDrawable(orig: Drawable?, @Px width: Int, @Px height: Int): Drawable? =
        App.INSTANCE.resizeDrawable(orig, width, height)

fun color(@ColorRes res: Int): Int = App.INSTANCE.color(res)

fun colorStateList(@ColorRes res: Int): ColorStateList = App.INSTANCE.colorStateList(res)

fun dimension(@DimenRes res: Int): Float = App.INSTANCE.dimension(res)

fun dimensionPixelOffset(@DimenRes res: Int): Int = App.INSTANCE.dimensionPixelOffset(res)

fun dimensionPixelSize(@DimenRes res: Int): Int = App.INSTANCE.dimensionPixelSize(res)

fun string(@StringRes res: Int) = App.INSTANCE.getString(res)

fun string(@StringRes res: Int, vararg formatArgs: Any) = App.INSTANCE.getString(res, formatArgs)