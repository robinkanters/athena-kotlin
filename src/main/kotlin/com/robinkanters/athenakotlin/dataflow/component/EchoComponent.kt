package com.robinkanters.athenakotlin.dataflow.component

import java.io.PrintStream

@DisplayName("Echo")
class EchoComponent(private val outputStream: PrintStream) : FlowComponent {
    override fun run(payload: String, flowVariables: FlowVariables): String {
        outputStream.println(payload)
        return payload
    }
}
