package com.robinkanters.athenakotlin.util.dummy

import com.robinkanters.athenakotlin.dataflow.component.FlowComponent
import com.robinkanters.athenakotlin.dataflow.component.FlowVariables

open class DummyFlowComponent : FlowComponent {
    override fun run(payload: String, flowVariables: FlowVariables): String {
        return ""
    }
}
