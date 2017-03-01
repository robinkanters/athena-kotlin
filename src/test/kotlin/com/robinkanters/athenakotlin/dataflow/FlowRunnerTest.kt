package com.robinkanters.athenakotlin.dataflow

import com.robinkanters.athenakotlin.dataflow.component.EchoComponent
import com.robinkanters.athenakotlin.dataflow.component.FlowComponent
import com.robinkanters.athenakotlin.dataflow.component.FlowVariables
import com.robinkanters.athenakotlin.util.dummy.DummyFlowVariables
import com.robinkanters.athenakotlin.util.spy.PrintStreamSpy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.assertEquals

class FlowRunnerTest {
    @Test
    fun passingEmptyStringIntoEmptyFlow_ReturnsEmptyString() {
        assertEquals("", Flow().run(""))
    }

    @Test
    fun passingNonEmptyStringIntoEmptyFlow_ReturnsThatStringUnmodified() {
        assertEquals("Foo", Flow().run("Foo"))
    }

    @Test
    fun flowWithEchoComponentReturnsStringEqualToInput() {
        val spy = PrintStreamSpy()

        val output = FlowRunner().run("Foo", EchoComponent(spy))

        assertEquals("Foo", output)
        assertEquals("Foo\n", spy.print)
    }

    @Test
    fun canRunSubFlows() {
        val spyExpectsFoo = SpyComponent()
        val spyExpectsBar = SpyComponent()

        val flowOutput = FlowRunner().run("foo", Flow(spyExpectsFoo), spyExpectsBar)

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
