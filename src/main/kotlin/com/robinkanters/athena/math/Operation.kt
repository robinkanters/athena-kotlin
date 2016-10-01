package com.robinkanters.athena.math

interface Operation {
    val symbol: Char

    fun calculate(left: Double, right: Double): Double
}
