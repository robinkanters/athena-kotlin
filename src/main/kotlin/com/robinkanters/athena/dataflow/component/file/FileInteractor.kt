package com.robinkanters.athena.dataflow.component.file

import java.io.File

open class FileInteractor {
    protected fun getFileForFilename(filename: String): File {
        return File(filename)
    }
}
