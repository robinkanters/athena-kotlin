package com.robinkanters.athena.util.mock

import com.robinkanters.athena.dataflow.component.file.FileReader

import java.util.HashMap

import org.junit.Assert.assertEquals

class MockFileReader : FileReader {
    internal var files: MutableMap<String, String> = HashMap()
    internal var readCalled = 0

    override fun read(filename: String): String {
        readCalled++
        return files[filename] ?: ""
    }

    fun add(filename: String, contents: String) {
        files.put(filename, contents)
    }

    fun assertReadCalled(amount: Int) {
        assertEquals(amount.toLong(), readCalled.toLong())
    }
}
