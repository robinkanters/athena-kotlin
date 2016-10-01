package com.robinkanters.athena.util.dummy

import com.robinkanters.athena.dataflow.component.FlowComponent
import com.robinkanters.athena.dataflow.component.FlowVariables

open class DummyFlowComponent : FlowComponent {
    override fun run(payload: String, flowVariables: FlowVariables): String {
        return ""
    }
}
