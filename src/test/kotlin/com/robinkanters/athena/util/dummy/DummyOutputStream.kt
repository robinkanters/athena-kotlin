package com.robinkanters.athena.util.dummy

import java.io.OutputStream

class DummyOutputStream : OutputStream() {
    override fun write(b: Int) {
    }
}
