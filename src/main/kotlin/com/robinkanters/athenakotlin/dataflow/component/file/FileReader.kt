package com.robinkanters.athenakotlin.dataflow.component.file

import java.io.IOException

interface FileReader {
    @Throws(IOException::class)
    fun read(filename: String): String
}
