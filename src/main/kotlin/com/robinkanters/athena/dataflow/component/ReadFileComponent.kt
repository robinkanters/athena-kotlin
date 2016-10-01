package com.robinkanters.athena.dataflow.component

import com.robinkanters.athena.dataflow.component.file.FileReader

@SuppressWarnings("WeakerAccess")
@DisplayName("Read file")
class ReadFileComponent(private val fileReader: FileReader) : FlowComponent {

    fun read(fileName: String): String {
        return fileReader.read(fileName)
    }

    override fun run(payload: String, flowVariables: FlowVariables): String {
        return read(payload)
    }
}
