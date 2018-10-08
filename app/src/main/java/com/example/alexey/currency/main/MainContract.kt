package com.example.alexey.currency.main

import com.example.alexey.currency.main.adapter.CurrencyItem
import java.math.BigDecimal

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
interface MainContract {
    interface Presenter {
        fun start()
        fun stopPolling()
        fun onItemClicked(item: CurrencyItem)
        fun onBaseMultiplierChanged(value: BigDecimal)
    }
    interface View {
        fun updateItems(items: List<CurrencyItem>)
        fun setInitItems(items: List<CurrencyItem>)
    }
}