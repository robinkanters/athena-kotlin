package com.robinkanters.athenakotlin.dataflow.component.file

import com.robinkanters.athenakotlin.dataflow.component.file.exception.FileWriterException
import com.robinkanters.athenakotlin.util.mock.FileWriterMock
import org.junit.Before
import org.junit.Test

class FileWriterImplTest {
    private val fileContents = "Foo"
    private var fileWriter: FileWriterMock = FileWriterMock()

    @Test
    fun read() {
        fileWriter.write("some file", fileContents)
        fileWriter.assertWriteCalled(1)
        fileWriter.assertWriteFileCalledWith(fileContents)
    }

    @Test(expected = FileWriterException::class)
    fun read_WhenThrowsIOException_IsConvertedIntoRuntimeException() {
        fileWriter.write("throw exception", fileContents)
        fileWriter.assertWriteCalled(0)
    }

}