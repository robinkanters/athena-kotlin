package com.robinkanters.athenakotlin.dataflow.locator

import com.robinkanters.athenakotlin.dataflow.component.FlowComponent
import java.util.function.Supplier

interface ComponentLocator {
    fun all(): List<Supplier<out FlowComponent>>

    fun filter(vararg filters: ComponentFilter): List<Supplier<out FlowComponent>>

    fun add(component: Supplier<out FlowComponent>)
}
