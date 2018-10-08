package com.example.alexey.currency.main.adapter

import com.mvideo.rtd_android.core.adapter.BaseAdapter
import com.mvideo.rtd_android.core.adapter.BaseHolder
import com.mvideo.rtd_android.core.adapter.IItemType
import java.math.BigDecimal

/**
 * Created by Alexey Osminin on 06.10.2018.
 */
class MainAdapter(baseValueListener: (value: BigDecimal) -> Unit) : BaseAdapter() {

    init {
        delegateAdapters.put(BASE_ITEM, BaseItemDelegateAdapter(baseValueListener))
        delegateAdapters.put(SIMPLE_ITEM, SimpleDelegateAdapter())
    }

    companion object {
        const val BASE_ITEM = 0
        const val SIMPLE_ITEM = 1
    }

    override fun onViewDetachedFromWindow(holder: BaseHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.unbind()
    }
}