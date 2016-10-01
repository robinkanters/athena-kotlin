package com.robinkanters.athena.util.mock

import com.robinkanters.athena.dataflow.component.file.FileWriter

import java.util.HashMap

import org.junit.Assert.assertEquals

class MockFileWriter : FileWriter {
    internal var files: MutableMap<String, String> = HashMap()
    internal var writeCalled = 0

    override fun write(fileName: String, contents: String) {
        files.put(fileName, contents)
        writeCalled++
    }

    operator fun get(filename: String): String? {
        return files[filename]
    }

    fun assertWriteCalled(amount: Int) {
        assertEquals(amount.toLong(), writeCalled.toLong())
    }
}
