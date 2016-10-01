package com.robinkanters.athenakotlin.datamapping

interface KeyValueStore {
    operator fun get(key: String): String?
}
