package com.robinkanters.athenakotlin.dataflow.locator

import com.robinkanters.athenakotlin.dataflow.component.FlowComponent
import java.util.*
import java.util.Arrays.stream
import java.util.function.Supplier

class FlowComponentLocatorImpl : ComponentLocator {
    private val components = ArrayList<Supplier<out FlowComponent>>()

    override fun all(): List<Supplier<out FlowComponent>> {
        return ArrayList(components)
    }

    override fun filter(vararg filters: ComponentFilter): List<Supplier<out FlowComponent>> {
        return all().filter({ componentCompliesToAllFilters(it, filters) })
    }

    private fun componentCompliesToAllFilters(c: Supplier<out FlowComponent>, filters:
    Array<out ComponentFilter>): Boolean {
        return stream(filters).allMatch { f -> f.test(c) }
    }

    override fun add(component: Supplier<out FlowComponent>) {
        if (components.contains(component))
            return

        components.add(component)
    }
}
