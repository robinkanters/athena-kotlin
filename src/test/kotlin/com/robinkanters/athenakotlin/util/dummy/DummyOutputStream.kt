package com.robinkanters.athenakotlin.util.dummy

import java.io.OutputStream

class DummyOutputStream : OutputStream() {
    override fun write(b: Int) {
    }
}
