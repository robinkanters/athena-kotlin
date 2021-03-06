package com.robinkanters.athena.dataflow.component

import com.robinkanters.athena.dataflow.component.file.FileWriter

class WriteFileComponent(private val fileName: String, private val fileWriter: FileWriter) : FlowComponent {

    override fun run(payload: String, flowVariables: FlowVariables): String {
        fileWriter.write(fileName, payload)
        return payload
    }
}
