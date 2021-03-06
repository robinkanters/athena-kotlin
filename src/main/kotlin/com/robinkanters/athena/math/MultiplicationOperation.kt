package com.robinkanters.athena.math

class MultiplicationOperation : Operation {
    override val symbol = '*'

    override fun calculate(left: Double, right: Double): Double {
        return left * right
    }
}
