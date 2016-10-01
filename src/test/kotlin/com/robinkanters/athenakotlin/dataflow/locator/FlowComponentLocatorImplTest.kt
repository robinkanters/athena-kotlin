package com.robinkanters.athenakotlin.dataflow.locator

import com.robinkanters.athenakotlin.dataflow.component.FlowComponent
import com.robinkanters.athenakotlin.util.dummy.DummyFlowComponent
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.lang.Math.min
import java.util.*
import java.util.Arrays.asList
import java.util.function.Supplier

class FlowComponentLocatorImplTest {
    private var componentLocator: FlowComponentLocatorImpl = FlowComponentLocatorImpl()

    private fun assertEmpty(all: List<*>) {
        assertTrue(all.isEmpty())
    }

    @SafeVarargs
    private fun assertListEquals(all: List<Supplier<out FlowComponent>>, components:
    List<Supplier<out FlowComponent>>) {
        assertEquals(components.size.toLong(), all.size.toLong())
        for (i in components.indices)
            assertEquals(components[i], all[i])
    }

    private fun addNComponents(requestedAmount: Int): List<Supplier<out FlowComponent>> {
        val amount = min(requestedAmount, supplierWarehouse.size)

        val components = ArrayList<Supplier<out FlowComponent>>()

        for (i in 0..amount - 1) {
            val component = supplierWarehouse[i]
            components.add(component)
            componentLocator.add(component)
        }

        return components
    }

    @Test
    fun beforeAdd_AllReturnsEmptyList() {
        assertEmpty(componentLocator.all())
    }

    @Test
    fun canAddComponent() {
        componentLocator.add(Supplier { DummyFlowComponent() })
    }

    @Test
    fun afterAddThreeComponents_AllReturnsAllThree() {
        val components = addNComponents(3)

        assertListEquals(componentLocator.all(), components)
    }

    @Test
    fun afterAddingTheSameComponentTwice_OnlyContainsOneInstance() {
        val component = Supplier { DummyFlowComponent() }

        componentLocator.add(component)
        componentLocator.add(component)

        assertListEquals(componentLocator.all(), asList(component))
    }

    @Test
    fun afteraddComponent_AllReturnsOnlyThatComponent() {
        val component = Supplier { DummyFlowComponent() }
        componentLocator.add(component)

        val all = componentLocator.all()

        assertListEquals(all, asList(component))
    }

    @Test
    fun filterWithoutSpecifyingFilters_ReturnsAll() {
        val components = addNComponents(3)

        val filteredComponents = componentLocator.filter()

        assertListEquals(filteredComponents, components)
    }

    @Test
    fun canFilter() {
        val components = addNComponents(3)

        val expectedComponents = asList(components[0], components[2])
        val filteredComponent = components[1].get()

        val filteredComponents = componentLocator.filter(object : ComponentFilter {
            override fun test(supplier: Supplier<out FlowComponent>): Boolean {
                return supplier.get().javaClass != filteredComponent.javaClass
            }
        })

        assertListEquals(filteredComponents, expectedComponents)
    }

    internal class DummyFlowComponent1 : DummyFlowComponent()
    internal class DummyFlowComponent2 : DummyFlowComponent()
    internal class DummyFlowComponent3 : DummyFlowComponent()
    internal class DummyFlowComponent4 : DummyFlowComponent()
    internal class DummyFlowComponent5 : DummyFlowComponent()

    companion object {
        internal val supplierWarehouse: MutableList<Supplier<out FlowComponent>> = ArrayList()

        init {
            supplierWarehouse.add(Supplier<FlowComponent> { DummyFlowComponent1() })
            supplierWarehouse.add(Supplier<FlowComponent> { DummyFlowComponent2() })
            supplierWarehouse.add(Supplier<FlowComponent> { DummyFlowComponent3() })
            supplierWarehouse.add(Supplier<FlowComponent> { DummyFlowComponent4() })
            supplierWarehouse.add(Supplier<FlowComponent> { DummyFlowComponent5() })
        }
    }
}
