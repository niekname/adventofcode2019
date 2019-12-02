package tv.mediagenix.aoc

import org.junit.jupiter.params.provider.Arguments

infix fun <I, R> I.returns(value: R) = Arguments.of(this, value)