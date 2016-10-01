package com.robinkanters.athena.datamapping

interface KeyValueStore {
    operator fun get(key: String): String?
}
