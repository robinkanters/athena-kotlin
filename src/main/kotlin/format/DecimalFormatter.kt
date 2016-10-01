package format

import java.text.DecimalFormat

open class DecimalFormatter {
    open fun format(input: Double): String {
        if (canBeCastToLong(input))
            return format(input.toLong())

        return formatDouble(input)
    }

    open fun format(input: Long): String {
        return formatDouble(input.toDouble())
    }

    private fun formatDouble(input: Double): String {
        val df = DecimalFormat("0.########")
        return df.format(input)
    }

    private fun canBeCastToLong(calculatedResult: Double): Boolean {
        return calculatedResult == calculatedResult.toLong().toDouble()
    }
}
