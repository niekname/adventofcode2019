package tv.mediagenix.aoc.day2p1

import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import tv.mediagenix.aoc.returns
import java.util.stream.Stream
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Day2Part1Test {

    @ParameterizedTest
    @MethodSource("test data")
    internal fun firstTestAddition(input: String, result: Int) {
        assertEquals(result, calculate(input))
    }

    private fun calculate(inputString: String): Int {
        val input = inputString.split(",")
                .map { it.toInt() }
                .toMutableList()

        for (i in 0 until input.size step 4) {
            val nextOpcode = input[i]
            if (nextOpcode == 99) return input[0]
            handleNextOpcode(nextOpcode, input, i)
        }

        return input[0]
    }

    private fun handleNextOpcode(nextOpcode: Int, input: MutableList<Int>, nextOpcodeIndex: Int) {
        when (nextOpcode) {
            1 -> input[input[3 + nextOpcodeIndex]] = input[input[1 + nextOpcodeIndex]] + input[input[2 + nextOpcodeIndex]]
            2 -> input[input[3 + nextOpcodeIndex]] = input[input[1 + nextOpcodeIndex]] * input[input[2 + nextOpcodeIndex]]
            else -> throw IllegalStateException()
        }
    }

    @Suppress("unused")
    private fun `test data`() = Stream.of(
            "1,0,0,0,99" returns 2,
            "1,3,0,0,99" returns 1,
            "2,0,0,0,99" returns 4,
            "2,1,0,0,99" returns 2,
            "2,4,4,0,99" returns 9801,
            "1,1,1,4,99,5,6,0,99" returns 30
    )
}