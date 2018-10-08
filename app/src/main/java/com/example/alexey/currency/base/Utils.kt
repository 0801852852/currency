package com.example.alexey.currency.base

import java.math.BigDecimal
import java.util.*

/**
 * Created by Alexey Osminin on 07.10.2018.
 */

fun BigDecimal.format() = setScale(2, BigDecimal.ROUND_HALF_UP).toString()

fun String.safeToBigDecimal(): BigDecimal {
    return try {
        BigDecimal(this)
    } catch (e: NumberFormatException) {
        BigDecimal.ZERO
    }
}