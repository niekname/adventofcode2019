package tv.mediagenix.aoc.day1

fun calculateModuleFuel(weight: Long): Long = weight / 3 - 2

fun calculateShipFuel(weights: Sequence<Long>) = weights.asSequence().map(::calculateModuleFuel).sum()
fun calculateShipFuel(vararg weights: Long) = calculateShipFuel(weights.asSequence())