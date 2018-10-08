package com.example.alexey.currency.data.network.api

import com.example.alexey.currency.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
class ApiProvider @Inject constructor(private val okHttpClient: OkHttpClient) : Provider<ICurrencyApi> {

    override fun get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ICurrencyApi::class.java)!!
}