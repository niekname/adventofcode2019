package tv.mediagenix.aoc.day8

data class Layer(
        val pixels: Array<IntArray>
) {
    val width = pixels.getOrNull(0)?.size ?: 0
    val height = pixels.size

    operator fun get(x: Int, y: Int) = pixels[y][x]

    companion object {
        fun parse(input: CharSequence, width: Int, height: Int): Layer {
            check(input.length == width * height) { "Size of $width x $height is invalid for input of size ${input.length} !" }
            return Layer(input.chunked(width) { chunk -> chunk.map { it.toString().toInt() }.toIntArray() }.toTypedArray())
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Layer

        if (!pixels.contentDeepEquals(other.pixels)) return false

        return true
    }

    override fun hashCode() = pixels.contentDeepHashCode()

    override fun toString() = pixels.joinToString(separator = "\n") { it.joinToString(separator = "") }
}