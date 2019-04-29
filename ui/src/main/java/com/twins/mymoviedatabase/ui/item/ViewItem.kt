package com.twins.mymoviedatabase.ui.item

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import com.mikepenz.fastadapter.IClickable
import com.mikepenz.fastadapter.IExpandable
import com.mikepenz.fastadapter.ISubItem
import com.mikepenz.fastadapter.items.AbstractItem
import com.mikepenz.fastadapter.listeners.OnClickListener
import com.twins.mymoviedatabase.core.util.unwrap

/**
 * Created by bukalapak on 11/9/17.
 */
class ViewItem<V : View>(
        val _type: Int,
        val generator: (Context, View) -> View
) : AbstractItem<ViewItem<V>,
        ViewHolder<V>>(),
        IExpandable<ViewItem<*>, ViewItem<*>>,
        ISubItem<ViewItem<*>, ViewItem<*>>,
        IClickable<ViewItem<V>> {

    private var _expanded: Boolean = false
    private var _subItems: MutableList<ViewItem<*>>? = null
    private var _parent: ViewItem<*>? = null
    private var binder: ((V, ViewItem<V>) -> Unit)? = null
    private var unbinder: ((V, ViewItem<V>) -> Unit)? = null

    /**
     * View to rotate when the item is clicked, perfect for expandable animation
     */
    @IdRes
    private var idViewToRotate: Int = 0
    private var rotation = 0

    private var _onItemClickListener: OnClickListener<ViewItem<V>>? = null
    private val defaultOnItemClickListener: OnClickListener<ViewItem<V>> = OnClickListener { v, adapter, item, position ->
        val viewToRotate = getViewToRotate(v)
        if (item.subItems != null && viewToRotate != null && rotation != 0) {
            if (item.isExpanded) {
                viewToRotate.animate().rotation(rotation.toFloat()).start()
            } else {
                viewToRotate.animate().rotation(0f).start()
            }
        }
        _onItemClickListener?.onClick(v, adapter, item, position) ?: true
    }

    private fun getViewToRotate(parent: View?): View? {
        return parent?.findViewById(idViewToRotate)
    }

    override fun withOnItemClickListener(onItemClickListener: OnClickListener<ViewItem<V>>?): ViewItem<V> {
        _onItemClickListener = onItemClickListener
        return this
    }

    override fun getOnItemClickListener(): OnClickListener<ViewItem<V>> {
        return defaultOnItemClickListener
    }

    override fun withSubItems(subItems: MutableList<ViewItem<*>>?): ViewItem<V> {
        _subItems = subItems
        subItems?.forEach { it.withParent(this) }
        return this
    }

    override fun getSubItems(): MutableList<ViewItem<*>>? = _subItems

    override fun withIsExpanded(expanded: Boolean): ViewItem<V> {
        _expanded = expanded
        return this
    }

    override fun isExpanded(): Boolean {
        return _expanded
    }

    override fun isAutoExpanding() = true

    @Deprecated("Use parent's withSubItems")
    override fun withParent(parent: ViewItem<*>?): ViewItem<V> {
        _parent = parent
        return this
    }

    override fun getParent(): ViewItem<*>? = _parent

    override fun getLayoutRes(): Int = 0

    override fun getType(): Int = _type

    override fun bindView(holder: ViewHolder<V>, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        unwrap(binder) {
            it.invoke(holder.view, this)
        }
        val viewToRotate = getViewToRotate(holder.view)
        unwrap(viewToRotate) { view ->
            if (rotation != 0 && isExpanded) {
                view.rotation = rotation.toFloat()
            } else {
                view.rotation = 0f
            }
        }
    }

    override fun unbindView(holder: ViewHolder<V>) {
        super.unbindView(holder)
        unwrap(unbinder) {
            it.invoke(holder.view, this)
        }
        getViewToRotate(holder.view)?.clearAnimation()
    }

    override fun generateView(ctx: Context, parent: ViewGroup): View {
        return generator.invoke(ctx, parent)
    }

    override fun getViewHolder(parent: ViewGroup): ViewHolder<V> {
        return getViewHolder(generateView(parent.context, parent))
    }

    override fun getViewHolder(v: View): ViewHolder<V> {
        return ViewHolder(v) as ViewHolder<V>
    }

    fun withBinder(f: (V, ViewItem<V>) -> Unit): ViewItem<V> {
        binder = f
        return this
    }

    fun withUnbinder(f: (V, ViewItem<V>) -> Unit): ViewItem<V> {
        unbinder = f
        return this
    }

    fun withViewToRotate(@IdRes id: Int): ViewItem<V> {
        this.idViewToRotate = id
        return this
    }

    fun withRotation(rotation: Int): ViewItem<V> {
        this.rotation = rotation
        return this
    }

}