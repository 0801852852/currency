package com.example.alexey.currency.data.network

import com.example.alexey.currency.data.network.api.ApiProvider
import com.example.alexey.currency.data.network.api.ICurrencyApi
import com.example.alexey.currency.data.network.api.OkHttpProvider
import com.google.gson.Gson
import okhttp3.OkHttpClient
import toothpick.config.Module

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
class NetworkModule : Module() {
    init {
        bind(Gson::class.java).toInstance(Gson())
        bind(OkHttpClient::class.java).toProviderInstance(OkHttpProvider())
        bind<ICurrencyApi>(ICurrencyApi::class.java).toProvider(ApiProvider::class.java)
    }
}