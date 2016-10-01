package com.robinkanters.athena.datamapping

import org.junit.Assert.assertEquals
import org.junit.Test

class IncrementerTest {
    private var incrementer: Incrementer = Incrementer()

    private fun assertNextValueIs(expected: Int) {
        assertEquals(expected.toLong(), incrementer.nextValue.toLong())
    }

    @Test
    fun valuesAreSequential() {
        assertNextValueIs(0)
        assertNextValueIs(1)
    }

    @Test
    fun incrementerWithStartValueReturnsThatAsFirstValue() {
        incrementer = Incrementer(4)
        assertNextValueIs(4)
    }

    @Test
    fun incrementerWithStartValueReturnsIncrementalIntegers() {
        incrementer = Incrementer(2)
        assertNextValueIs(2)
        assertNextValueIs(3)
        assertNextValueIs(4)
    }

    @Test
    fun incrementerWithStepValueReturnsIntegersThatDifferByThatAmount() {
        incrementer = Incrementer(1, 2)
        assertNextValueIs(1)
        assertNextValueIs(3)
    }

    @Test
    fun greaterStartValue() {
        incrementer = Incrementer(10, 2)
        assertNextValueIs(10)
        assertNextValueIs(12)
    }

    @Test
    fun greaterStepValue() {
        incrementer = Incrementer(4, 5)
        assertNextValueIs(4)
        assertNextValueIs(9)
    }
}
