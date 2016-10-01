package com.robinkanters.athena.dataflow.component

import com.robinkanters.athena.dataflow.Flow
import com.robinkanters.athena.util.dummy.DummyFlowVariables
import com.robinkanters.athena.util.mock.MockFileReader
import org.junit.Before
import org.junit.Test

import org.junit.Assert.assertEquals

class FileReadComponentTest {
    private val mockFileReader: MockFileReader = MockFileReader()
    private val readFileComponent: ReadFileComponent = ReadFileComponent(mockFileReader)
    private val variables: DummyFlowVariables = DummyFlowVariables()

    private val fileContents: String = "Foobar"
    private val fileName: String = "/tmp/test.txt"

    @Before
    fun setUp() {
        mockFileReader.add(fileName, fileContents)
    }

    @Test
    fun canReadFile() {
        val output = readFileComponent.read(fileName)

        assertEquals(fileContents, output)
        mockFileReader.assertReadCalled(1)
    }

    @Test
    fun ifPayloadIsFileName_AfterComponentInvocation_PayloadIsFileContents() {
        val flow = Flow()
        flow.addComponent(readFileComponent)

        val actualPayload = flow.run(fileName, variables)

        assertEquals(fileContents, actualPayload)
        mockFileReader.assertReadCalled(1)
    }
}
