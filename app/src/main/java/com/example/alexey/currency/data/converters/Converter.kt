package com.example.alexey.currency.data.converters

import com.example.alexey.currency.data.local.model.Currency
import com.example.alexey.currency.data.local.model.CurrencyLocal
import com.example.alexey.currency.data.network.models.CurrencyJson
import com.example.alexey.currency.data.network.models.CurrencyJson.*
import com.example.alexey.currency.data.network.models.CurrencyResponse

/**
 * Created by Alexey Osminin on 06.10.2018.
 */

fun CurrencyResponse.toLocal() = rates.entries.map { entry ->
    CurrencyLocal(entry.key.toLocal(), false, entry.value)
}

fun CurrencyJson.toLocal() = when (this) {
    BGN -> Currency.BGN
    AUD -> Currency.AUD
    BRL -> Currency.BRL
    CAD -> Currency.CAD
    CHF -> Currency.CHF
    CNY -> Currency.CNY
    CZK -> Currency.CZK
    DKK -> Currency.DKK
    EUR -> Currency.EUR
    GBP -> Currency.GBP
    HKD -> Currency.HKD
    HRK -> Currency.HRK
    HUF -> Currency.HUF
    IDR -> Currency.IDR
    ILS -> Currency.ILS
    INR -> Currency.INR
    ISK -> Currency.ISK
    JPY -> Currency.JPY
    KRW -> Currency.KRW
    MXN -> Currency.MXN
    MYR -> Currency.MYR
    NOK -> Currency.NOK
    NZD -> Currency.NZD
    PHP -> Currency.PHP
    PLN -> Currency.PLN
    RON -> Currency.RON
    RUB -> Currency.RUB
    SEK -> Currency.SEK
    SGD -> Currency.SGD
    THB -> Currency.THB
    TRY -> Currency.TRY
    USD -> Currency.USD
    ZAR -> Currency.ZAR
}
    