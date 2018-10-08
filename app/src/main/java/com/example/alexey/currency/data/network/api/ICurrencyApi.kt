package com.example.alexey.currency.data.network.api

import com.example.alexey.currency.data.network.models.CurrencyResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
interface ICurrencyApi {
    @GET("/latest")
    fun getCurrencyRate(@Query("base") base: String): Single<CurrencyResponse>
}