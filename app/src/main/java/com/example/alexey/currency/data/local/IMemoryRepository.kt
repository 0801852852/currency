package com.example.alexey.currency.data.local

import com.example.alexey.currency.data.local.model.CurrencyLocal
import io.reactivex.Single

/**
 * Created by Alexey Osminin on 07.10.2018.
 */
interface IMemoryRepository {
    fun saveItems(items: List<CurrencyLocal>)
    fun getItems(base: CurrencyLocal): Single<List<CurrencyLocal>>
}