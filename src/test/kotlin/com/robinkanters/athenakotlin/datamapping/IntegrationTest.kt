package com.robinkanters.athenakotlin.datamapping

import org.junit.Before
import org.junit.Test

import org.junit.Assert.assertEquals

class IntegrationTest {
    private var arithmeticEvaluator: ArithmeticEvaluator = ArithmeticEvaluator()
    private var variableEvaluator: VariableEvaluator? = null

    private fun assertEvaluates(input: String, expectedOutput: String) {
        val actualResult = arithmeticEvaluator.evaluate(variableEvaluator!!.evaluate(input))
        assertEquals(expectedOutput, actualResult)
    }

    @Before
    fun setUp() {
        val variables = Variables()
        variables.put("var1", 1)
        variables.put("var2", 2)
        variableEvaluator = VariableEvaluator(variables)
    }

    @Test
    fun variablesAndArithmetic() {
        assertEvaluates("{var1}+{var2}", "3")
    }
}
