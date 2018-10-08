package com.example.alexey.currency.data.polling

import com.example.alexey.currency.data.local.model.CurrencyLocal
import io.reactivex.Observable

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
interface IPollingInteractor {
    fun getPollingObservable(base: CurrencyLocal) : Observable<List<CurrencyLocal>>
}