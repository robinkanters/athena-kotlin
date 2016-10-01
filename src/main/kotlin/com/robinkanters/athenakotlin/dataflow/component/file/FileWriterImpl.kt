package com.robinkanters.athenakotlin.dataflow.component.file

import com.robinkanters.athenakotlin.dataflow.component.file.exception.FileWriterException

import java.io.File
import java.io.IOException
import java.nio.charset.Charset

import org.apache.commons.io.FileUtils.writeStringToFile

open class FileWriterImpl : FileInteractor(), FileWriter {
    override fun write(fileName: String, contents: String) {
        try {
            tryWrite(fileName, contents)
        } catch (e: IOException) {
            throw FileWriterException(e)
        }
    }

    @Throws(IOException::class)
    protected open fun tryWrite(filename: String, contents: String) {
        val f = getFileForFilename(filename)
        writeFile(f, contents)
    }

    @Throws(IOException::class)
    protected open fun writeFile(f: File, contents: String) {
        writeStringToFile(f, contents, Charset.defaultCharset())
    }
}
