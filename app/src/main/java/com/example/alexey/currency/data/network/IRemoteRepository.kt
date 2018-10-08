package com.example.alexey.currency.data.network

import com.example.alexey.currency.data.local.model.CurrencyLocal
import io.reactivex.Single

/**
 * Created by Alexey Osminin on 09.10.2018.
 */
interface IRemoteRepository {
    fun getCurrencyRate(base: CurrencyLocal): Single<List<CurrencyLocal>>
}