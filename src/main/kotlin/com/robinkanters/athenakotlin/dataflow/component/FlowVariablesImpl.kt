package com.robinkanters.athenakotlin.dataflow.component

import java.util.HashMap

class FlowVariablesImpl : HashMap<String, String>(), FlowVariables {
    override fun set(key: String, value: String) {
        put(key, value)
    }

    override fun has(key: String): Boolean {
        return containsKey(key)
    }

    override fun remove(key: String): String? {
        if (!has(key))
            throw FlowVariables.NoSuchVariableException(key)
        return super.remove(key)
    }
}
