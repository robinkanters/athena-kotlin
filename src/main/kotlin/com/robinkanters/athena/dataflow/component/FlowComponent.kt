package com.robinkanters.athena.dataflow.component

@DisplayName("")
interface FlowComponent {
    fun run(payload: String, flowVariables: FlowVariables): String

    fun getDisplayName(): String {
        val annotation = javaClass.getAnnotation(DisplayName::class.java)

        return if (annotation != null)
            annotation.value
        else
            javaClass.simpleName
    }
}
