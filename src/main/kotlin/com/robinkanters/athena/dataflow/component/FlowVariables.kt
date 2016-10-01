package com.robinkanters.athena.dataflow.component

interface FlowVariables {
    operator fun set(key: String, value: String)

    fun has(key: String): Boolean

    operator fun get(key: String): String?

    @Throws(NoSuchVariableException::class)
    fun remove(key: String): String?

    class NoSuchVariableException(message: String) : RuntimeException(message)
}
