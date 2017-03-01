package com.robinkanters.athenakotlin.dataflow

import com.robinkanters.athenakotlin.dataflow.component.FlowComponent
import com.robinkanters.athenakotlin.dataflow.component.FlowVariables
import com.robinkanters.athenakotlin.dataflow.component.FlowVariablesImpl

class FlowRunner(val flowVariables: FlowVariables = FlowVariablesImpl()) {
    fun run(payload: String, vararg components: FlowComponent): String {
        return run(payload, components.asList())
    }

    tailrec fun run(payload: String, components: List<FlowComponent>): String {
        if (components.isEmpty())
            return payload

        return run(
                components.first().run(payload, flowVariables),
                components.drop(1)
        )
    }
}
