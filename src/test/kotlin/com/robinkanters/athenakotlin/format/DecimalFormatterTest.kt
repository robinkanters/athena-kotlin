package com.robinkanters.athenakotlin.format

import com.robinkanters.athenakotlin.format.DecimalFormatter
import org.junit.Assert.assertEquals
import org.junit.Test

class DecimalFormatterTest {
    private val formatter = DecimalFormatter()

    @Test
    fun formatSimpleDouble() {
        assertFormatsAs(1.0, "1")
    }

    private fun assertFormatsAs(input: Double, expected: String) {
        assertEquals(expected, formatter.format(input))
    }

    @Test
    fun formatDoubleWithNonZeroDecimals() {
        //@formatter:off
        assertFormatsAs(1.1, "1.1")
        assertFormatsAs(1.12, "1.12")
        assertFormatsAs(1.123, "1.123")
        assertFormatsAs(1.1234, "1.1234")
        assertFormatsAs(1.12345, "1.12345")
        assertFormatsAs(1.123456, "1.123456")
        assertFormatsAs(1.1234567, "1.1234567")
        assertFormatsAs(1.12345678, "1.12345678")
        //@formatter:on
    }

    @Test
    fun formatDoubleWithMoreThanEightDecimalsIsRoundedCorrectly() {
        val roundedDown = "1.12345678"
        assertFormatsAs(1.123456785, roundedDown)

        val roundedUp = "1.12345679"
        assertFormatsAs(1.123456786, roundedUp)
    }

    @Test
    fun formatLong() {
        assertEquals("1", formatter.format(1.toLong()))
        assertEquals("10", formatter.format(10.toLong()))
    }
}
