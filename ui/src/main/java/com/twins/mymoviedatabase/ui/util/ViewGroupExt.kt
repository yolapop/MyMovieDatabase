package com.twins.mymoviedatabase.ui.util

import android.os.Bundle
import android.os.Parcelable
import android.support.annotation.LayoutRes
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup

/**
 * Created by bukalapak on 11/8/17.
 */
fun ViewGroup.contentRes(@LayoutRes res: Int): View {
    return View.inflate(context, res, this)
}

// region keep children states
val CHILDREN_STATE_KEY = "CHILDREN_STATE_KEY"
val INSTANCE_STATE_KEY = "INSTANCE_STATE_KEY"

fun ViewGroup.saveKeepChildrenStates(superInstanceState: Parcelable): Bundle {
    val bundle = Bundle()
    bundle.putParcelable(INSTANCE_STATE_KEY, superInstanceState)
    val childrenStates = SparseArray<Parcelable>()
    for (index in 0 until childCount) {
        getChildAt(index).saveHierarchyState(childrenStates)
    }
    bundle.putSparseParcelableArray(CHILDREN_STATE_KEY, childrenStates)
    return bundle
}

fun ViewGroup.restoreKeepChildrenStates(state: Parcelable?): Parcelable? {
    val childrenStates = (state as Bundle).getSparseParcelableArray<Parcelable>(CHILDREN_STATE_KEY)
    for (index in 0 until childCount) {
        getChildAt(index).restoreHierarchyState(childrenStates)
    }
    val instanceState = state.getParcelable<Parcelable>(INSTANCE_STATE_KEY)
    return instanceState
}
// endregion