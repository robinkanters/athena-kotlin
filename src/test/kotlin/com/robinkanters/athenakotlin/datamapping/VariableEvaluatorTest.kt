package com.robinkanters.athenakotlin.datamapping

import com.robinkanters.athenakotlin.datamapping.VariableEvaluator.VariableNotDefinedException
import org.junit.Assert.assertEquals
import org.junit.Test

class VariableEvaluatorTest {
    private val variables = Variables()
    private val variableEvaluator = VariableEvaluator(variables)

    private fun assertEvaluatesAs(input: String, expected: String) {
        assertEquals(expected, variableEvaluator.evaluate(input))
    }

    @Test
    fun emptyStringReturnsEmptyString() {
        assertEvaluatesAs("", "")
    }

    @Test
    fun stringWithoutVariablesIsReturnedTheSame() {
        assertEvaluatesAs("foo", "foo")
    }

    @Test
    fun variableWithinCurlyBracesReturnsValueOfThatVariable() {
        variables.put("variable", "bar")

        assertEvaluatesAs("{variable}", "bar")
        assertEvaluatesAs("{variable}{variable}", "barbar")
    }

    @Test(expected = VariableNotDefinedException::class)
    fun usingAnUnknownVariable_ThrowsException() {
        variableEvaluator.evaluate("{nonexistentVariable}")
    }
}
