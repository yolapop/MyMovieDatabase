package com.twins.mymoviedatabase.ui.util

import android.os.Binder
import android.os.Bundle
import androidx.core.app.BundleCompat
import kotlin.reflect.KProperty

/**
 * Implement this class in a custom view to use [ViewStateDelegate]
 */
interface ViewState {

    /**
     * Holder for all states in a View
     */
    val savedState: MutableMap<String, Any?>

    /**
     * To be called in [android.view.ViewGroup.onSaveInstanceState]
     */
    fun putStateToBundle(bundle: Bundle): Bundle {
        for ((key, value) in savedState) {
            when (value) {
                is String? -> bundle.putString(key, value)
                is Int -> bundle.putInt(key, value)
                is Short -> bundle.putShort(key, value)
                is Long -> bundle.putLong(key, value)
                is Byte -> bundle.putByte(key, value)
                is ByteArray -> bundle.putByteArray(key, value)
                is Char -> bundle.putChar(key, value)
                is CharArray? -> bundle.putCharArray(key, value)
                is CharSequence? -> bundle.putCharSequence(key, value)
                is Float -> bundle.putFloat(key, value)
                is Bundle? -> bundle.putBundle(key, value)
                is Binder? -> BundleCompat.putBinder(bundle, key, value)
                is android.os.Parcelable? -> bundle.putParcelable(key, value)
                is java.io.Serializable? -> bundle.putSerializable(key, value)
            }
        }
        return bundle
    }

    /**
     * To be called in [android.view.ViewGroup.onRestoreInstanceState]
     */
    fun restoreStateFromBundle(bundle: Bundle) {
        for (key in bundle.keySet()) {
            savedState[key] = bundle[key]
        }
    }

}

class ViewStateDelegate<T>(private val initial: T,
                           private val observer: ((T) -> Unit)? = null) :
        kotlin.properties.ReadWriteProperty<ViewState, T> {

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: ViewState, property: KProperty<*>): T {
        val v = thisRef.savedState[property.name] as T
        return v ?: initial
    }

    override fun setValue(thisRef: ViewState, property: KProperty<*>, value: T) {
        thisRef.savedState[property.name] = value
        observer?.invoke(value)
    }

}