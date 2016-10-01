package com.robinkanters.athena.dataflow.component

import com.robinkanters.athena.dataflow.Flow
import com.robinkanters.athena.util.dummy.DummyFlowVariables
import com.robinkanters.athena.util.spy.FlowComponentSpy
import com.robinkanters.athena.util.stub.StubComponent
import org.junit.Before
import org.junit.Test

import org.junit.Assert.assertEquals

class SetPayloadComponentTest {
    private var constructorPayload: String = "payload"
    private var setPayloadComponent: SetPayloadComponent = SetPayloadComponent(constructorPayload)
    private var variables: DummyFlowVariables = DummyFlowVariables()

    private fun assertComponentReturns(input: String, expectedOutput: String) {
        assertComponentReturns(input, FlowVariablesImpl(), expectedOutput)
    }

    private fun assertComponentReturns(input: String, variables: FlowVariables, expectedOutput: String) {
        assertEquals(expectedOutput, setPayloadComponent.run(input, variables))
    }

    @Test
    fun whenGivenNull_ReturnsPayloadFromConstructor() {
        assertComponentReturns("", constructorPayload)
        assertComponentReturns("Foo", constructorPayload)
    }

    @Test
    fun whenComponentIncorporatedInFlow_ChangesPayloadMidFlow() {
        val f = Flow()
        f.addComponent(StubComponent())
        f.addComponent(setPayloadComponent)

        val printStreamSpy = FlowComponentSpy()
        f.addComponent(printStreamSpy)

        f.run("Foo", variables)

        assertEquals(constructorPayload, printStreamSpy.incomingPayload)
    }
}
