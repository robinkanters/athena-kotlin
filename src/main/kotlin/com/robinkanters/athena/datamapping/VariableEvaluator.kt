package com.robinkanters.athena.datamapping

import java.util.regex.Pattern

class VariableEvaluator(private val variables: KeyValueStore) : Evaluator {
    private val variablesPattern = ".*\\{(\\w+?)\\}.*"

    override fun evaluate(input: String): String {
        if (stringHasInterpolatedVariable(input))
            return replaceVariables(input)
        return input
    }

    private fun replaceVariables(input: String): String {
        if (!stringHasInterpolatedVariable(input))
            return input

        val variableName = getInterpolatedVariableName(input)
        return replaceVariables(input.replace("{$variableName}", getReplacement(variableName)))
    }

    private fun getReplacement(variableName: String): String {
        try {
            return variables[variableName]!!
        } catch (e: KotlinNullPointerException) {
            throw VariableNotDefinedException(variableName)
        }
    }

    private fun getInterpolatedVariableName(input: String): String {
        val p = Pattern.compile(variablesPattern)
        val matcher = p.matcher(input)
        matcher.find()

        return matcher.group(1)
    }

    private fun stringHasInterpolatedVariable(input: String): Boolean {
        return input.matches(variablesPattern.toRegex())
    }

    internal inner class VariableNotDefinedException internal constructor(name: String) :
            RuntimeException("Variable $name not found")
}
