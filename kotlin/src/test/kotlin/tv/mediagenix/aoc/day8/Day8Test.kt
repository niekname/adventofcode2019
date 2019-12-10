package tv.mediagenix.aoc.day8

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Day8Test {

    @Test
    fun testPart1Example() {
        assertEquals(Image(
                arrayOf(Layer(arrayOf(
                        intArrayOf(1, 2, 3),
                        intArrayOf(4, 5, 6)
                )), Layer(arrayOf(
                        intArrayOf(7, 8, 9),
                        intArrayOf(0, 1, 2)
                )))
        ), Image.parse("123456789012", 3, 2))
    }

    @Test
    fun solvePart1() {
        val image = Image.parse(Day8Test::class.java.getResourceAsStream("/day8p1input.txt").reader().readLines().single(), 25, 6)
        println("The image :\n$image")

        // fewest 0 digits
        val layer = image.layers.minBy { layer -> layer.pixels.sumBy { it.count { px -> px == 0 } } }!!
        println("The layer :\n$layer")

        val d1 = layer.pixels.sumBy { it.count { px -> px == 1 } }
        val d2 = layer.pixels.sumBy { it.count { px -> px == 2 } }
        println("The result of $d1 * $d2 is ${d1 * d2}")
    }

    @Test
    fun testPart2Example() {
        assertEquals(Layer(
                arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(1, 0)
                )
        ), Image.parse("0222112222120000", 2, 2).squash())
    }

    @Test
    fun solvePart2() {
        val layer = Image.parse(Day8Test::class.java.getResourceAsStream("/day8p1input.txt").reader().readLines().single(), 25, 6).squash()
        println("The decoded image is:\n${layer.toString().replace('0', ' ').replace('1', 'X')}")
    }
}