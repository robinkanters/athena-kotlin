package com.robinkanters.athenakotlin.datamapping

import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

class ArithmeticEvaluatorTest {
    private val arithmeticEvaluator: ArithmeticEvaluator = ArithmeticEvaluator()

    private fun assertEvaluates(operation: String, expectation: String) {
        assertEquals(expectation, arithmeticEvaluator.evaluate(operation))
    }

    @Test
    fun ifPassedASimpleNumber_ReturnsThatNumber() {
        assertEvaluates("1", "1")
        assertEvaluates("2", "2")
    }

    @Test
    fun onePlusTwoReturnsThree() {
        assertEvaluates("1+2", "3")
    }

    @Test
    fun twelveMinusNineIsThree() {
        assertEvaluates("12-9", "3")
    }

    @Test
    fun twoTimesFourIsEight() {
        assertEvaluates("2*4", "8")
    }

    @Test
    fun twoTimesThreePlusFourIsTen() {
        assertEvaluates("2*3+4", "10")
    }

    @Test
    fun sixOverTwoIsThree() {
        assertEvaluates("6/2", "3")
    }

    @Test
    fun eightOverTwoTimesThreeIsTwelve() {
        assertEvaluates("8/2*3", "12")
    }

    @Ignore
    @Test
    fun twoToPowerThreeIsEight() {
        assertEvaluates("2^3", "8")
    }

    @Ignore
    @Test
    fun sixPlusTwoToPowerTwoIsTen() {
        assertEvaluates("6+2^2", "10")
    }

    @Ignore
    @Test
    fun tenToPowerMinusTwoIsOneHundredth() {
        assertEvaluates("10^-2", "0.01")
    }
}
