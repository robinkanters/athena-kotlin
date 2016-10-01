package com.robinkanters.athenakotlin.datamapping

class Incrementer : ValueGenerator {
    private val step: Int
    private var value: Int = 0

    constructor() {
        step = 1
    }

    constructor(start: Int) {
        value = start
        step = 1
    }

    constructor(start: Int, step: Int) {
        value = start
        this.step = step
    }

    override val nextValue: Int
        get() {
            val result = value
            value += step

            return result
        }
}
