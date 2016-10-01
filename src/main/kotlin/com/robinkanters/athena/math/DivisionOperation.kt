package com.robinkanters.athena.math

class DivisionOperation : Operation {
    override val symbol = '/'

    override fun calculate(left: Double, right: Double): Double {
        return left / right
    }
}
