package com.example.alexey.currency.data.local.model

import java.math.BigDecimal

/**
 * Created by Alexey Osminin on 06.10.2018.
 */
data class CurrencyLocal(val currency: Currency,
                         val isBase: Boolean,
                         val value: BigDecimal)
