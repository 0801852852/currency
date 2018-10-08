package com.example.alexey.currency.data.network.api

import com.example.alexey.currency.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Provider

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
class OkHttpProvider : Provider<OkHttpClient> {

    companion object {
        private const val DEFAULT_TIMEOUT = 5L
    }

    override fun get(): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .followRedirects(false)

        if (BuildConfig.DEBUG) {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logger)
        }

        return builder.build()
    }
}