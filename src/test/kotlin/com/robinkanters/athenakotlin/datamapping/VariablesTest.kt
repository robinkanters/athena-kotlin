package com.robinkanters.athenakotlin.datamapping

import com.robinkanters.athenakotlin.format.DecimalFormatter
import org.junit.Before
import org.junit.Test

import org.junit.Assert.assertEquals

class VariablesTest {
    private val decimalFormatterSpy = DecimalFormatterSpy()
    private val variables = Variables(decimalFormatterSpy)

    @Test
    fun put_Integer() {
        variables.put("Foo", 1)

        assertEquals("1", variables["Foo"])

        decimalFormatterSpy.assertFormatDoubleCalled(0)
        decimalFormatterSpy.assertFormatLongCalled(0)
    }

    @Test
    fun put_Long_NoDecimals() {
        variables.put("Foo", 1L)

        assertEquals("1", variables["Foo"])

        decimalFormatterSpy.assertFormatDoubleCalled(0)
        decimalFormatterSpy.assertFormatLongCalled(1)
    }

    @Test
    fun put_Double_WithoutDecimals_FormatedAsLong() {
        variables.put("Foo", 1.0)

        assertEquals("1", variables["Foo"])

        decimalFormatterSpy.assertFormatDoubleCalled(1)
        decimalFormatterSpy.assertFormatLongCalled(1)
    }

    @Test
    fun put_Double_WithDecimals() {
        variables.put("Foo", 1.1)

        assertEquals("1.1", variables["Foo"])

        decimalFormatterSpy.assertFormatDoubleCalled(1)
        decimalFormatterSpy.assertFormatLongCalled(0)
    }

    private inner class DecimalFormatterSpy : DecimalFormatter() {
        private var formatDoubleCalled = 0
        private var formatLongCalled = 0

        override fun format(input: Double): String {
            formatDoubleCalled++
            return super.format(input)
        }

        override fun format(input: Long): String {
            formatLongCalled++
            return super.format(input)
        }

        internal fun assertFormatDoubleCalled(times: Int) {
            assertEquals(times.toLong(), formatDoubleCalled.toLong())
        }

        internal fun assertFormatLongCalled(times: Int) {
            assertEquals(times.toLong(), formatLongCalled.toLong())
        }
    }
}
