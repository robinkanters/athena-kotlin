package com.robinkanters.athena.dataflow.component.file

interface FileWriter {
    fun write(fileName: String, contents: String)
}
