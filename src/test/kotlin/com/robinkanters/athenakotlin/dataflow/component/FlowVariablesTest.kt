package com.robinkanters.athenakotlin.dataflow.component

import com.robinkanters.athenakotlin.dataflow.component.FlowVariables.NoSuchVariableException
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class FlowVariablesTest {
    private var flowVariables: FlowVariables = FlowVariablesImpl()

    @Test
    fun beforeSet_HasReturnsFalse() {
        assertFalse(flowVariables.has(KEY))
    }

    @Test
    fun beforeSet_GetReturnsNull() {
        assertEquals(null, flowVariables[KEY])
    }

    @Test(expected = NoSuchVariableException::class)
    fun beforeSet_RemoveThrowsException() {
        flowVariables.remove(KEY)
    }

    @Test
    fun afterSet_GetReturnsOriginalValue() {
        flowVariables[KEY] = VALUE

        assertTrue(flowVariables.has(KEY))
        assertEquals(VALUE, flowVariables[KEY])
    }

    @Test
    fun afterSetAndRemove_HasReturnsFalse() {
        flowVariables[KEY] = VALUE
        flowVariables.remove(KEY)

        assertFalse(flowVariables.has(KEY))
    }

    @Test
    fun afterSetX_YIsNotSet() {
        flowVariables[KEY] = VALUE

        assertTrue(flowVariables.has(KEY))
        assertFalse(flowVariables.has("Y"))
    }

    companion object {
        private val KEY = "key"
        private val VALUE = "value"
    }
}