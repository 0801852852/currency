package com.example.alexey.currency.data.local

import com.example.alexey.currency.data.local.model.CurrencyLocal
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Alexey Osminin on 07.10.2018.
 */

//The simplest way of "local" storage :)
class MemoryRepositoryImpl @Inject constructor() : IMemoryRepository {

    private var items: List<CurrencyLocal> = emptyList()

    override fun saveItems(items: List<CurrencyLocal>) {
        this.items = items
    }

    override fun getItems(base: CurrencyLocal) = Single.just(listOf(base).plus(items
            .filterNot { it.currency == base.currency }
            .sortedBy { it.currency.string }))!!
}