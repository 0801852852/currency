package com.example.alexey.currency.data.network

import com.example.alexey.currency.data.converters.toLocal
import com.example.alexey.currency.data.local.model.CurrencyLocal
import com.example.alexey.currency.data.network.api.ICurrencyApi
import javax.inject.Inject

/**
 * Created by Alexey Osminin on 09.10.2018.
 */
class RemoteRepositoryImpl @Inject constructor(private val api: ICurrencyApi): IRemoteRepository {
    override fun getCurrencyRate(base: CurrencyLocal)
            = api.getCurrencyRate(base.currency.string)
            .map { it.toLocal().sortedBy { it.currency.string } }!!
}