package com.robinkanters.athenakotlin.util.spy

import com.robinkanters.athenakotlin.dataflow.component.FlowComponent
import com.robinkanters.athenakotlin.dataflow.component.FlowVariables

class FlowComponentSpy : FlowComponent {
    var incomingPayload: String? = null
        private set

    override fun run(payload: String, flowVariables: FlowVariables): String {
        this.incomingPayload = payload
        return payload
    }
}
