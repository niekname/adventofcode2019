package tv.mediagenix.aoc.day1p1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    internal fun `test weights from examples`() {
        assertEquals(2, calculateModuleFuel(12))
        assertEquals(2, calculateModuleFuel(14))
        assertEquals(654, calculateModuleFuel(1969))
        assertEquals(33_583, calculateModuleFuel(100_756))
    }

    @Test
    internal fun `test summing weighs`() {
        assertEquals(34_241, calculateShipFuel(12, 14, 1969, 100_756))
    }

    @Test
    internal fun `solve the actual problem`() {
        println(calculateShipFuel(
                CalculatorTest::class.java.getResourceAsStream("/input.txt").reader().readLines()
                        .asSequence().map(String::toLong)
        ))
    }
}
