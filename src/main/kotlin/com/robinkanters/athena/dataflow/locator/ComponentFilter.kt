package com.robinkanters.athena.dataflow.locator

import com.robinkanters.athena.dataflow.component.FlowComponent

import java.util.function.Supplier

interface ComponentFilter {
    fun test(supplier: Supplier<out FlowComponent>): Boolean
}
