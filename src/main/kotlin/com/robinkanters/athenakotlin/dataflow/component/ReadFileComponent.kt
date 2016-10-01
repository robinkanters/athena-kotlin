package com.robinkanters.athenakotlin.dataflow.component

import com.robinkanters.athenakotlin.dataflow.component.file.FileReader

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
