package com.robinkanters.athena.util.dummy

import java.io.OutputStream
import java.io.PrintStream

open class DummyPrintStream : PrintStream {
    constructor() : super(DummyOutputStream()) {
    }

    constructor(stream: OutputStream) : super(stream) {
    }

    override fun println(x: String) {
        // do nothing
    }
}
