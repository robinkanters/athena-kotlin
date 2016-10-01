package com.robinkanters.athena.dataflow.component

import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.Retention

@Retention(RUNTIME)
annotation class DisplayName(val value: String)
