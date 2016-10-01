package com.robinkanters.athena.datamapping

import format.DecimalFormatter

import java.util.HashMap

class Variables : HashMap<String, String>, KeyValueStore {
    private var formatter = DecimalFormatter()

    constructor()
    constructor(formatter: DecimalFormatter?) {
        this.formatter = formatter ?: DecimalFormatter()
    }

    fun put(key: String, value: Int) {
        put(key, value.toString())
    }

    fun put(key: String, value: Double) {
        put(key, formatter.format(value))
    }

    fun put(key: String, value: Long) {
        put(key, formatter.format(value))
    }
}
