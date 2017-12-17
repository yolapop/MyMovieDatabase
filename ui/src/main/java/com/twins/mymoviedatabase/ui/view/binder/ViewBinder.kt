package com.twins.mymoviedatabase.ui.view.binder

import android.view.View
import com.twins.mymoviedatabase.ui.view.state.ViewBaseState

/**
 * Created by Yolanda-PC on 17/12/2017.
 */
interface ViewBinder<in V : View, in S : ViewBaseState> {

    fun bind(view: V, state: S)

}