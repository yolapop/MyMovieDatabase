package com.twins.mymoviedatabase.catalog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.twins.mymoviedatabase.core.util.dimensionPixelSize
import com.twins.mymoviedatabase.ui.item.ViewItem
import com.twins.mymoviedatabase.ui.util.Frame
import com.twins.mymoviedatabase.ui.util.wrapInFrameLayout
import com.twins.mymoviedatabase.ui.view.binder.TextViewBinder
import com.twins.mymoviedatabase.ui.view.state.TextViewState
import com.twins.mymoviedatabase.ui.view.state.ViewStateBase
import kotlinx.android.synthetic.main.recycler_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = createCatalogAdapter()
    }

    private fun createCatalogAdapter(): FastItemAdapter<ViewItem<*>> {
        val adapter = FastItemAdapter<ViewItem<*>>()
        val titleMap = createNameMapping()
        val itemState = TextViewState().apply {
            minHeight = ViewStateBase.MIN_HEIGHT_LIST
            padding = Frame(vertical = dimensionPixelSize(R.dimen.space_1x),
                    horizontal = dimensionPixelSize(R.dimen.space_2x))
            textGravity = Gravity.CENTER_VERTICAL
            useSelectableForeground = true
        }
        val viewId = listOf(FrameLayout::class, TextView::class).hashCode()
        val items = titleMap.map { (key, klass) ->
            ViewItem<FrameLayout>(viewId) { ctx, _ ->
                TextView(ctx).wrapInFrameLayout().apply {
                    layoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT)
                }
            }.withBinder { view, _ ->
                itemState.text = key
                TextViewBinder.bind(view, itemState)
            }.withOnItemClickListener { _, _, _, _ ->
                this.startActivity(Intent(this, klass))
                true
            }
        }
        adapter.set(items)
        return adapter
    }

    private fun createNameMapping(): Map<String, Class<out Activity>> {
        val map = mutableMapOf<String, Class<out Activity>>()
        map["Movie Rectangle Card"] = MovieRectangleCardActivity::class.java
        return map
    }

}
