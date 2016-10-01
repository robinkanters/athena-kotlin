package com.robinkanters.athenakotlin.util.mock

import com.robinkanters.athenakotlin.dataflow.component.file.FileWriterImpl
import org.junit.Assert

import java.io.File
import java.io.IOException

import org.junit.Assert.assertEquals

class FileWriterMock : FileWriterImpl() {
    private var calledWriteWith: String? = null
    private var writeCalled = 0

    override fun writeFile(f: File, contents: String) {
        calledWriteWith = contents
        writeCalled++
    }

    fun assertWriteFileCalledWith(expected: String) {
        assertEquals(expected, calledWriteWith)
    }

    fun assertWriteCalled(expected: Int) {
        assertEquals(expected.toLong(), writeCalled.toLong())
    }

    public override fun tryWrite(filename: String, contents: String) {
        if (filename.startsWith("throw"))
            throw IOException("test")
        super.tryWrite(filename, contents)
    }
}
