package com.robinkanters.athenakotlin.dataflow.component.file

import com.robinkanters.athenakotlin.dataflow.component.file.exception.FileReaderException
import org.junit.Before
import org.junit.Test

import java.io.File
import java.io.IOException

import org.junit.Assert.assertEquals

class FileReaderImplTest {
    private val fileContents = "Foo"
    private val fileReader = MockFileReader()

    @Test
    fun read() {
        assertEquals(fileContents, fileReader.read("some file"))
    }

    @Test(expected = FileReaderException::class)
    fun read_WhenThrowsIOException_IsConvertedIntoRuntimeException() {
        assertEquals(fileContents, fileReader.read("throw exception"))
    }

    private inner class MockFileReader : FileReaderImpl() {
        override fun readFile(f: File): String {
            return fileContents
        }

        public override fun tryRead(filename: String): String {
            if (filename.startsWith("throw"))
                throw IOException("test")

            return super.tryRead(filename)
        }
    }
}