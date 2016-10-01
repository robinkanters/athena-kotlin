package com.robinkanters.athenakotlin.util.dummy

import com.robinkanters.athenakotlin.dataflow.component.FlowVariables

class DummyFlowVariables : FlowVariables {
    override fun set(key: String, value: String) {
        // do nothing
    }

    override fun has(key: String): Boolean {
        return false
    }

    override fun get(key: String): String? {
        return null
    }

    override fun remove(key: String): String? {
        return null
    }
}
