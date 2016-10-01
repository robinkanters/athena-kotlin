package com.robinkanters.athena.util.stub

import com.robinkanters.athena.dataflow.component.FlowComponent
import com.robinkanters.athena.dataflow.component.FlowVariables

class StubComponent : FlowComponent {
    override fun run(payload: String, flowVariables: FlowVariables): String {
        return payload
    }
}
