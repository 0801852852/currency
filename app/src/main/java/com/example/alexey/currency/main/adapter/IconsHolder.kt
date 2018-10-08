package com.example.alexey.currency.main.adapter

import com.example.alexey.currency.R
import com.example.alexey.currency.data.local.model.Currency

/**
 * Created by Alexey Osminin on 07.10.2018.
 */
fun getIcon(currency: Currency) =
        when (currency) {
            Currency.BGN -> R.drawable.flag_bgn
            Currency.AUD -> R.drawable.flag_aud
            Currency.BRL -> R.drawable.flag_brl
            Currency.CAD -> R.drawable.flag_cad
            Currency.CHF -> R.drawable.flag_chf
            Currency.CNY -> R.drawable.flag_cny
            Currency.CZK -> R.drawable.flag_czk
            Currency.DKK -> R.drawable.flag_dkk
            Currency.EUR -> R.drawable.flag_eur
            Currency.GBP -> R.drawable.flag_gbp
            Currency.HKD -> R.drawable.flag_hkd
            Currency.HRK -> R.drawable.flag_hrk
            Currency.HUF -> R.drawable.flag_huf
            Currency.IDR -> R.drawable.flag_idr
            Currency.ILS -> R.drawable.flag_ils
            Currency.INR -> R.drawable.flag_inr
            Currency.ISK -> R.drawable.flag_isk
            Currency.JPY -> R.drawable.flag_jpy
            Currency.KRW -> R.drawable.flag_krw
            Currency.MXN -> R.drawable.flag_mxn
            Currency.MYR -> R.drawable.flag_myr
            Currency.NOK -> R.drawable.flag_nok
            Currency.NZD -> R.drawable.flag_nzd
            Currency.PHP -> R.drawable.flag_php
            Currency.PLN -> R.drawable.flag_pln
            Currency.RON -> R.drawable.flag_ron
            Currency.RUB -> R.drawable.flag_rub
            Currency.SEK -> R.drawable.flag_sek
            Currency.SGD -> R.drawable.flag_sgd
            Currency.THB -> R.drawable.flag_thb
            Currency.TRY -> R.drawable.flag_try
            Currency.USD -> R.drawable.flag_usd
            Currency.ZAR -> R.drawable.flag_zar
        }