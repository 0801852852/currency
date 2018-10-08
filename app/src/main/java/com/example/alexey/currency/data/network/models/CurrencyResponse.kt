package com.example.alexey.currency.data.network.models

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class CurrencyResponse(
        @SerializedName("base") val base: String,
        @SerializedName("date") val date: String,
        @SerializedName("rates") val rates: Map<CurrencyJson, BigDecimal>
)