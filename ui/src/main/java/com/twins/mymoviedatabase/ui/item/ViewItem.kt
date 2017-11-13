package com.twins.mymoviedatabase.ui.item

import android.view.View
import android.view.ViewGroup
import com.mikepenz.fastadapter.IClickable
import com.mikepenz.fastadapter.IExpandable
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.ISubItem

/**
 * Created by bukalapak on 11/9/17.
 */
interface ViewItem<T : View> : IItem<ViewItem<T>, ViewHolder<T>>,
        IExpandable<ViewItem<*>, ViewItem<*>>, ISubItem<ViewItem<*>, ViewItem<*>>,
        IClickable<ViewItem<T>> {

    var _expanded: Boolean
    var _subItems: MutableList<ViewItem<*>>?
    var _parent: ViewItem<*>?

    override fun withSubItems(subItems: MutableList<ViewItem<*>>?): ViewItem<T> {
        _subItems = subItems
        subItems?.forEach { it.withParent(this) }
        return this
    }

    override fun getSubItems(): MutableList<ViewItem<*>>? = _subItems

    override fun withIsExpanded(expanded: Boolean): ViewItem<T> {
        _expanded = expanded
        return this
    }

    override fun isExpanded(): Boolean {
        return _expanded
    }

    override fun isAutoExpanding() = true

    @Deprecated("Use parent's withSubItems")
    override fun withParent(parent: ViewItem<*>?): ViewItem<T> {
        _parent = parent
        return this
    }

    override fun getParent(): ViewItem<*>? = _parent

    override fun getLayoutRes(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getType(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getViewHolder(parent: ViewGroup?): ViewHolder<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}