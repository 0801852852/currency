package com.example.alexey.currency.main.adapter

import com.example.alexey.currency.data.local.model.CurrencyLocal
import com.example.alexey.currency.main.adapter.MainAdapter.Companion.BASE_ITEM
import com.example.alexey.currency.main.adapter.MainAdapter.Companion.SIMPLE_ITEM
import com.mvideo.rtd_android.core.adapter.IItemType

/**
 * Created by Alexey Osminin on 06.10.2018.
 */
data class CurrencyItem(val currency: CurrencyLocal,
                        val imageId: Int,
                        val nameId: Int) : IItemType {
    override fun getItemType() = if (currency.isBase) BASE_ITEM else SIMPLE_ITEM
}