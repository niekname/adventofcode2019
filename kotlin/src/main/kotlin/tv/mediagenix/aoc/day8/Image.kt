package tv.mediagenix.aoc.day8

data class Image(
        val layers: Array<Layer>
) {
    val width = layers.first().width
    val height = layers.first().height
    val layerCount = layers.size

    operator fun get(index: Int) = this.layers[index]

    fun squash() = Layer(
            Array(height) { y ->
                IntArray(width) { x ->
                    this.layers.asSequence().map { it[x, y] }.find { px -> px != TRANSPARENT } ?: TRANSPARENT
                }
            }
    )

    companion object {
        const val BLACK = 0
        const val WHITE = 1
        const val TRANSPARENT = 2

        fun parse(input: String, width: Int, height: Int): Image {
            val s = width * height
            check(input.length / s.toDouble() == (input.length / s).toDouble()) { "Size of $width x $height is invalid for input of size ${input.length} !" }
            return Image(input.chunked(s) { Layer.parse(it, width, height) }.toTypedArray())
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Image

        if (!layers.contentEquals(other.layers)) return false

        return true
    }

    override fun hashCode() = layers.contentHashCode()

    override fun toString() = layers.mapIndexed { index, layer -> "Layer $index:\n$layer" }.joinToString(separator = "\n")
}