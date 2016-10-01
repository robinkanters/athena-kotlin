package com.robinkanters.athena.util.spy

import com.robinkanters.athena.util.dummy.DummyOutputStream
import com.robinkanters.athena.util.dummy.DummyPrintStream

class PrintStreamSpy : DummyPrintStream(DummyOutputStream()) {
    var print: String = ""
        private set

    override fun println(x: String) {
        print += x
        print += "\n"
    }
}
