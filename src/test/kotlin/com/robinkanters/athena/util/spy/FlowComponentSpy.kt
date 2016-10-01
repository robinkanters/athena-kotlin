package com.robinkanters.athena.util.spy

import com.robinkanters.athena.dataflow.component.FlowComponent
import com.robinkanters.athena.dataflow.component.FlowVariables

class FlowComponentSpy : FlowComponent {
    var incomingPayload: String? = null
        private set

    override fun run(payload: String, flowVariables: FlowVariables): String {
        this.incomingPayload = payload
        return payload
    }
}
