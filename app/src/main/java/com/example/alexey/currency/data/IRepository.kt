package com.example.alexey.currency.data

import com.example.alexey.currency.data.local.model.CurrencyLocal
import io.reactivex.Observable

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
interface IRepository {
    fun getCurrencyObservable(base: CurrencyLocal): Observable<List<CurrencyLocal>>
}