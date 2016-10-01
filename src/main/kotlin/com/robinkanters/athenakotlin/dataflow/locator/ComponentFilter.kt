package com.robinkanters.athenakotlin.dataflow.locator

import com.robinkanters.athenakotlin.dataflow.component.FlowComponent

import java.util.function.Supplier

interface ComponentFilter {
    fun test(supplier: Supplier<out FlowComponent>): Boolean
}
