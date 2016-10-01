package com.robinkanters.athenakotlin.dataflow.component

@DisplayName("Set payload")
class SetPayloadComponent(private val payload: String) : FlowComponent {
    override fun run(payload: String, flowVariables: FlowVariables): String {
        return this.payload
    }
}
