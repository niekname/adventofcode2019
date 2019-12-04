package tv.mediagenix.aoc.day1p2

fun calculateModuleFuel(weight: Long): Long {
    var totalFuel = 0L
    var fuel = weight / 3 - 2
    while (fuel > 0) {
        totalFuel += fuel
        fuel = fuel / 3 - 2
    }
    return totalFuel
}

/**
 * Recursive example, given for completeness.
 * Will be much slower than [calculateModuleFuel] !
 */
fun calculateModuleFuelRecursive(weight: Long): Long {
    val fuel = weight / 3 - 2
    return if (fuel <= 0) 0 else fuel + calculateModuleFuelRecursive(fuel)
}

/**
 * Recursive code compiling to iterative bytecode.
 * Will have similar speed to [calculateModuleFuel].
 */
tailrec fun calculateModuleFuelTailRecursive(weight: Long, total: Long = 0) : Long {
    val fuel = weight / 3 - 2
    return if (fuel <= 0) total else calculateModuleFuelTailRecursive(fuel, fuel + total)
}

fun calculateShipFuel(weights: Sequence<Long>) = weights.asSequence().map(::calculateModuleFuel).sum()
fun calculateShipFuel(vararg weights: Long) = calculateShipFuel(weights.asSequence())