package com.twins.mymoviedatabase.core

/**
 * Created by Yolanda-PC on 24/12/2017.
 */
// TODO: finish MVP barebone
interface Mvp {

    interface Presenter<in V : View> {
        var view: View?
        fun attachView(v: V)
        fun detachView()
    }

    interface View {

    }

}