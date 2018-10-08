package com.mvideo.rtd_android.core.adapter

import android.support.annotation.CallSuper
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Alexey Osminin on 06.10.2018.
 */

abstract class BaseHolder(view: View) : RecyclerView.ViewHolder(view) {
    protected lateinit var data: IItemType

    @CallSuper
    open fun bind(item: IItemType) {
        data = item
    }

    abstract fun unbind()

    fun setOnItemClickListener(listener: (IItemType) -> Unit) {
        itemView.setOnClickListener { listener(data) }
    }
}