package com.twins.mymoviedatabase.core.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.drawable.DrawableWrapper
import android.util.TypedValue
import android.widget.Toast

/**
 * Created by bukalapak on 10/2/17.
 */
fun Context.toastShort(msg: CharSequence?) {
    msg?.let {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

fun Context.toastLong(msg: CharSequence?) {
    msg?.let {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}

fun Context.drawable(@DrawableRes res: Int?, @ColorRes tint: Int? = null): Drawable? {
    return if (res == null) null else drawable(getDrawable(res), tint)
}

fun Context.drawable(d: Drawable?, @ColorRes tint: Int? = null): Drawable? {
    return d?.mutate().apply {
        tint?.let {
            this?.setTint(ContextCompat.getColor(this@drawable, it))
        }
    }
}

fun Context.resizeDrawable(@DrawableRes d: Int?, @Px width: Int, @Px height: Int): Drawable? {
    return resizeDrawable(drawable(d), width, height)
}

@SuppressLint("RestrictedApi")
fun Context.resizeDrawable(orig: Drawable?, @Px width: Int, @Px height: Int): Drawable? {
    var _d = orig
    when(orig) {
        is DrawableWrapper -> _d = orig.wrappedDrawable
    }
    return (_d as? BitmapDrawable)?.bitmap?.let {
        val bitmapResized = Bitmap.createScaledBitmap(it, width, height, true)
        BitmapDrawable(this@resizeDrawable.resources, bitmapResized)
    } ?: orig
}

@ColorInt
fun Context.color(@ColorRes res: Int): Int {
    return ContextCompat.getColor(this, res)
}

fun Context.colorStateList(@ColorRes res: Int): ColorStateList {
    return ContextCompat.getColorStateList(this, res)!!
}

fun Context.dimension(@DimenRes res: Int): Float {
    return this.resources.getDimension(res)
}

fun Context.dimensionPixelOffset(@DimenRes res: Int): Int {
    return this.resources.getDimensionPixelOffset(res)
}

fun Context.dimensionPixelSize(@DimenRes res: Int): Int {
    return resources.getDimensionPixelSize(res)
}

fun Context.dpToPx(value: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics)
}