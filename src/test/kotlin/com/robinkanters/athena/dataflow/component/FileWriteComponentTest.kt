package com.robinkanters.athena.dataflow.component

import com.robinkanters.athena.dataflow.Flow
import com.robinkanters.athena.util.dummy.DummyFlowVariables
import com.robinkanters.athena.util.mock.MockFileWriter
import org.junit.Before
import org.junit.Test

import org.junit.Assert.assertEquals

class FileWriteComponentTest {
    private val fileName: String = "/tmp/test.txt"
    private val fileContents: String = "Foobar"

    private val mockFileWriter: MockFileWriter = MockFileWriter()
    private val writeFileComponent: WriteFileComponent = WriteFileComponent(fileName, mockFileWriter)
    private val variables: DummyFlowVariables = DummyFlowVariables()

    @Test
    fun canWriteFile() {
        val returnedPayload = writeFileComponent.run(fileContents, variables)

        mockFileWriter.assertWriteCalled(1)
        assertEquals(fileContents, returnedPayload)
        assertEquals(fileContents, mockFileWriter[fileName])
    }

    @Test
    fun ifPayloadIsFileName_AfterComponentInvocation_PayloadIsFileContents() {
        val flow = Flow()
        flow.addComponent(writeFileComponent)

        val actualPayload = flow.run(fileContents, variables)

        assertEquals(fileContents, actualPayload)
        mockFileWriter.assertWriteCalled(1)
    }
}
