package com.robinkanters.athenakotlin.dataflow.component.file

import com.robinkanters.athenakotlin.dataflow.component.file.exception.FileReaderException
import org.apache.commons.io.FileUtils

import java.io.File
import java.io.IOException
import java.nio.charset.Charset

open class FileReaderImpl : FileInteractor(), FileReader {
    override fun read(filename: String): String {
        try {
            return tryRead(filename)
        } catch (e: IOException) {
            throw FileReaderException(e)
        }
    }

    @Throws(IOException::class)
    protected open fun tryRead(filename: String): String {
        return readFile(getFileForFilename(filename))
    }

    @Throws(IOException::class)
    protected open fun readFile(f: File): String {
        return FileUtils.readFileToString(f, Charset.defaultCharset())
    }
}
