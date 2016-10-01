package com.robinkanters.athenakotlin.dataflow.component.file

interface FileWriter {
    fun write(fileName: String, contents: String)
}
