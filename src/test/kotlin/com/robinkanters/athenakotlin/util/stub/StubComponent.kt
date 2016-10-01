package com.robinkanters.athenakotlin.util.stub

import com.robinkanters.athenakotlin.dataflow.component.FlowComponent
import com.robinkanters.athenakotlin.dataflow.component.FlowVariables

class StubComponent : FlowComponent {
    override fun run(payload: String, flowVariables: FlowVariables): String {
        return payload
    }
}
