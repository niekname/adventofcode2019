package tv.mediagenix.aoc.day1p2

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import tv.mediagenix.aoc.returns
import java.util.stream.Stream
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CalculatorTest {

    @ParameterizedTest
    @MethodSource("exampleData")
    fun `test weights from examples`(input: Long, expected: Long) {
        assertEquals(expected, calculateModuleFuel(input))
    }

    @ParameterizedTest
    @MethodSource("exampleData")
    fun `test weights from examples with recursive call`(input: Long, expected: Long) {
        assertEquals(expected, calculateModuleFuelRecursive(input))
    }

    @ParameterizedTest
    @MethodSource("exampleData")
    fun `test weights from examples with tailrec call`(input: Long, expected: Long) {
        assertEquals(expected, calculateModuleFuelTailRecursive(input))
    }

    @Suppress("unused")
    private fun exampleData() = Stream.of(
            12 returns 2,
            14 returns 2,
            1969 returns 966,
            100_756 returns 50_346
    )

    @Test
    internal fun `test summing weighs`() {
        assertEquals(51_316, calculateShipFuel(12, 14, 1969, 100_756))
    }

    @Test
    internal fun `solve the actual problem`() {
        println(calculateShipFuel(
                CalculatorTest::class.java.getResourceAsStream("/input.txt").reader().readLines()
                        .asSequence().map(String::toLong)
        ))
    }
}
