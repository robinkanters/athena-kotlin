package com.robinkanters.athenakotlin.dataflow

import com.robinkanters.athenakotlin.dataflow.component.FlowComponent
import com.robinkanters.athenakotlin.dataflow.component.FlowVariables
import com.robinkanters.athenakotlin.dataflow.component.FlowVariablesImpl

import java.util.ArrayList

open class Flow(var components: MutableList<FlowComponent>) : FlowComponent {
    constructor(vararg components: FlowComponent) : this(ArrayList<FlowComponent>()) {
        this.components.addAll(components)
    }

    fun run(payload: String): String {
        return run(payload, FlowVariablesImpl())
    }

    override fun run(payload: String, flowVariables: FlowVariables): String {
        return FlowRunner(flowVariables).run(payload, components)
    }

    fun addComponent(flowComponent: FlowComponent) {
        components.add(flowComponent)
    }
}
