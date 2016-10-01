package com.robinkanters.athenakotlin.dataflow

import com.robinkanters.athenakotlin.dataflow.component.FlowComponent
import com.robinkanters.athenakotlin.dataflow.component.FlowVariables
import com.robinkanters.athenakotlin.dataflow.component.FlowVariablesImpl

import java.util.ArrayList

open class Flow : FlowComponent {
    protected var components: MutableList<FlowComponent> = ArrayList()

    fun run(payload: String): String {
        return run(payload, FlowVariablesImpl())
    }

    override fun run(payload: String, flowVariables: FlowVariables): String {
        var mutablePayload = payload

        for (component in components)
            mutablePayload = component.run(mutablePayload, flowVariables)

        return mutablePayload
    }

    fun addComponent(flowComponent: FlowComponent) {
        components.add(flowComponent)
    }
}
