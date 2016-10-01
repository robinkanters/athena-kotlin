package com.robinkanters.athena.datamapping

import format.DecimalFormatter
import com.robinkanters.athena.math.*

class ArithmeticEvaluator : Evaluator {
    private var input: String? = null
    private var operation: Operation? = null
    private val decimalFormatter = DecimalFormatter()

    @SuppressWarnings("WeakerAccess")
    override fun evaluate(input: String): String {
        this.input = input
        if (hasAddition())
            return calculateAddition()
        else if (hasSubtraction())
            return calculateSubtraction()
        else if (hasMultiplication())
            return calculateMultiplication()
        else if (hasDivision())
            return calculateDivision()
        return input
    }

    private fun hasAddition(): Boolean {
        return input!!.matches(".*\\d\\+\\d.*".toRegex())
    }

    private fun hasSubtraction(): Boolean {
        return input!!.matches(".*\\d-\\d.*".toRegex())
    }

    private fun hasMultiplication(): Boolean {
        return input!!.matches(".*\\d\\*\\d.*".toRegex())
    }

    private fun hasDivision(): Boolean {
        return input!!.matches(".*\\d/\\d.*".toRegex())
    }

    private fun calculateAddition(): String {
        return calculateAndFormatResult(AdditionOperation())
    }

    private fun calculateSubtraction(): String {
        return calculateAndFormatResult(SubtractionOperation())
    }

    private fun calculateMultiplication(): String {
        return calculateAndFormatResult(MultiplicationOperation())
    }

    private fun calculateDivision(): String {
        return calculateAndFormatResult(DivisionOperation())
    }

    private fun calculateAndFormatResult(operation: Operation): String {
        return decimalFormatter.format(calculateResult(operation))
    }

    private fun calculateResult(operation: Operation): Double {
        this.operation = operation
        return operation.calculate(java.lang.Double.parseDouble(evaluateLeft()), java.lang.Double.parseDouble(evaluateRight()))
    }

    private fun evaluateNested(operation: String): String {
        return ArithmeticEvaluator().evaluate(operation)
    }

    private fun evaluateLeft(): String {
        val expression = input!!.substring(0, input!!.indexOf(operand))
        return evaluateNested(expression)
    }

    private fun evaluateRight(): String {
        val expression = input!!.substring(input!!.indexOf(operand) + 1)
        return evaluateNested(expression)
    }

    private val operand: Char
        get() = operation!!.symbol
}
