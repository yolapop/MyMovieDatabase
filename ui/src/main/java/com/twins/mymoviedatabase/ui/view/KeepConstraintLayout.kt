package com.twins.mymoviedatabase.ui.view

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.util.SparseArray
import androidx.constraintlayout.widget.ConstraintLayout
import com.twins.mymoviedatabase.core.util.restoreKeepChildrenStates
import com.twins.mymoviedatabase.core.util.saveKeepChildrenStates
import com.twins.mymoviedatabase.ui.util.ViewState

/**
 * Created by bukalapak on 11/16/17.
 */
open class KeepConstraintLayout @JvmOverloads constructor(context: Context,
                                                    attrs: AttributeSet? = null,
                                                    defStyleAttr: Int = 0) :
        ConstraintLayout(context, attrs, defStyleAttr), ViewState {

    override val savedState: MutableMap<String, Any?> = mutableMapOf()

    override fun onRestoreInstanceState(state: Parcelable?) {
        restoreStateFromBundle(state as Bundle)
        super.onRestoreInstanceState(restoreKeepChildrenStates(state))
    }

    override fun dispatchRestoreInstanceState(container: SparseArray<Parcelable>?) {
        dispatchThawSelfOnly(container)
    }

    override fun dispatchSaveInstanceState(container: SparseArray<Parcelable>?) {
        dispatchFreezeSelfOnly(container)
    }

    override fun onSaveInstanceState(): Parcelable {
        return putStateToBundle(saveKeepChildrenStates(superInstanceState = super.onSaveInstanceState()))
    }

}