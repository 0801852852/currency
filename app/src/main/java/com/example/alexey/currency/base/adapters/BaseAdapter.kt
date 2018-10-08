package com.mvideo.rtd_android.core.adapter

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.ViewGroup

/**
 * Created by Alexey Osminin on 06.10.2018.
 */

abstract class BaseAdapter : RecyclerView.Adapter<BaseHolder>() {
    protected val delegateAdapters: SparseArray<IDelegateAdapter> = SparseArray()
    var itemClickListener: ((IItemType) -> Unit)? = null
    var items: List<IItemType> = ArrayList()

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = items[position].getItemType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val holder = delegateAdapters.get(viewType).onCreateViewHolder(parent)
        if (itemClickListener != null) {
            holder.setOnItemClickListener(itemClickListener!!)
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) = holder.bind(items[position])
}