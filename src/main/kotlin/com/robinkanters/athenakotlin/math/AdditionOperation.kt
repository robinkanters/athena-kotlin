package com.robinkanters.athenakotlin.math

class AdditionOperation : Operation {
    override val symbol = '+'

    override fun calculate(left: Double, right: Double): Double {
        return left + right
    }
}
