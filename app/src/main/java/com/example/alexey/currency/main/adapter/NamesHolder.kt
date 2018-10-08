package com.example.alexey.currency.main.adapter

import com.example.alexey.currency.R
import com.example.alexey.currency.data.local.model.Currency

/**
 * Created by Alexey Osminin on 07.10.2018.
 */
fun getName(currency: Currency) = 
        when (currency) {
            Currency.BGN -> R.string.long_bgn
            Currency.AUD -> R.string.long_aud
            Currency.BRL -> R.string.long_brl
            Currency.CAD -> R.string.long_cad
            Currency.CHF -> R.string.long_chf
            Currency.CNY -> R.string.long_cny
            Currency.CZK -> R.string.long_czk
            Currency.DKK -> R.string.long_dkk
            Currency.EUR -> R.string.long_eur
            Currency.GBP -> R.string.long_gbp
            Currency.HKD -> R.string.long_hkd
            Currency.HRK -> R.string.long_hrk
            Currency.HUF -> R.string.long_huf
            Currency.IDR -> R.string.long_idr
            Currency.ILS -> R.string.long_ils
            Currency.INR -> R.string.long_inr
            Currency.ISK -> R.string.long_isk
            Currency.JPY -> R.string.long_jpy
            Currency.KRW -> R.string.long_krw
            Currency.MXN -> R.string.long_mxn
            Currency.MYR -> R.string.long_myr
            Currency.NOK -> R.string.long_nok
            Currency.NZD -> R.string.long_nzd
            Currency.PHP -> R.string.long_php
            Currency.PLN -> R.string.long_pln
            Currency.RON -> R.string.long_ron
            Currency.RUB -> R.string.long_rub
            Currency.SEK -> R.string.long_sek
            Currency.SGD -> R.string.long_sgd
            Currency.THB -> R.string.long_thb
            Currency.TRY -> R.string.long_try
            Currency.USD -> R.string.long_usd
            Currency.ZAR -> R.string.long_zar
        }