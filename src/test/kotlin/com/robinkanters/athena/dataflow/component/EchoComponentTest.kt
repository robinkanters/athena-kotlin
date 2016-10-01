package com.robinkanters.athena.dataflow.component

import com.robinkanters.athena.util.dummy.DummyFlowVariables
import com.robinkanters.athena.util.spy.PrintStreamSpy
import org.junit.Assert.assertEquals
import org.junit.Test

class EchoComponentTest {
    private val spy: PrintStreamSpy = PrintStreamSpy()
    private val flowComponent: EchoComponent = EchoComponent(spy)
    private val variables: FlowVariables = DummyFlowVariables()

    @Test
    fun runReturnsInputAsOutput() {
        assertEquals("Foo", flowComponent.run("Foo", variables))
    }

    @Test
    fun runPrintsPayloadToOutput() {
        flowComponent.run("Foo", variables)

        assertEquals("Foo\n", spy.print)
    }

    @Test
    fun canGetDisplayName() {
        val displayName = flowComponent.javaClass.getAnnotation(DisplayName::class.java).value
        assertEquals(displayName, flowComponent.getDisplayName())
    }
}
