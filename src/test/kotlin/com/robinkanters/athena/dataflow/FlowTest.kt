package com.robinkanters.athena.dataflow

import com.robinkanters.athena.dataflow.component.EchoComponent
import com.robinkanters.athena.dataflow.component.FlowComponent
import com.robinkanters.athena.dataflow.component.FlowVariables
import com.robinkanters.athena.util.dummy.DummyFlowVariables
import com.robinkanters.athena.util.spy.PrintStreamSpy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.assertEquals

class FlowTest {
    val flow: Flow = Flow()

    @Test
    fun passingEmptyStringIntoEmptyFlow_ReturnsEmptyString() {
        assertEquals("", flow.run(""))
    }

    @Test
    fun passingNonEmptyStringIntoEmptyFlow_ReturnsThatStringUnmodified() {
        assertEquals("Foo", flow.run("Foo"))
    }

    @Test
    fun flowWithEchoComponentReturnsStringEqualToInput() {
        val spy = PrintStreamSpy()

        flow.addComponent(EchoComponent(spy))
        val output = flow.run("Foo")

        assertEquals("Foo", output)
        assertEquals("Foo\n", spy.print)
    }

    @Test
    fun canHaveSubFlows() {
        val subflow = Flow()
        val spyExpectsFoo = SpyComponent()
        val spyExpectsBar = SpyComponent()

        flow.addComponent(subflow)
        subflow.addComponent(spyExpectsFoo)
        flow.addComponent(spyExpectsBar)

        val flowOutput = flow.run("foo")

        assertEquals("foo\n", spyExpectsFoo.trace)
        assertEquals("bar\n", spyExpectsBar.trace)
        assertEquals("bar", flowOutput)
    }

    private inner class SpyComponent : FlowComponent {
        var trace = ""
            private set

        override fun run(payload: String, flowVariables: FlowVariables): String {
            trace += payload
            trace += "\n"

            return "bar"
        }
    }
}
