package com.robinkanters.athenakotlin.util.spy

import com.robinkanters.athenakotlin.util.dummy.DummyOutputStream
import com.robinkanters.athenakotlin.util.dummy.DummyPrintStream

class PrintStreamSpy : DummyPrintStream(DummyOutputStream()) {
    var print: String = ""
        private set

    override fun println(x: String) {
        print += x
        print += "\n"
    }
}
