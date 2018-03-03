package com.twins.mymoviedatabase.catalog

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.ViewGroup
import android.widget.TextView
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.twins.mymoviedatabase.ui.item.ViewItem
import com.twins.mymoviedatabase.ui.util.Frame
import com.twins.mymoviedatabase.ui.view.binder.TextViewBinder
import com.twins.mymoviedatabase.ui.view.state.TextViewState
import com.twins.mymoviedatabase.ui.view.state.ViewBaseState
import kotlinx.android.synthetic.main.recycler_view.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)
        recyclerView.adapter = createCatalogAdapter()
    }

    private fun createCatalogAdapter(): FastItemAdapter<ViewItem<*>> {
        val adapter = FastItemAdapter<ViewItem<*>>()
        val titleMap = createNameMapping()
        val itemState = TextViewState().apply {
            minHeight = ViewBaseState.MIN_HEIGHT_LIST
            padding = Frame()
        }
        val items = titleMap.map { (key, _) -> ViewItem<TextView>(TextView::class.hashCode(),
                { ctx, parent ->
                    TextView(ctx).apply {
                        layoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT)
                    }
        }).withBinder { view, viewItem ->
            view.text = key
            TextViewBinder.bind(view, itemState)
        }}
        adapter.set(items)
        return adapter
    }

    private fun createNameMapping(): Map<String, Class<out Activity>> {
        val map = mutableMapOf<String, Class<out Activity>>()
        map["Movie Rectangle Card"] = MovieRectangleCardActivity::class.java
        return map
    }

}
