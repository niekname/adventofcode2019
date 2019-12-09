package tv.mediagenix.aoc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Day8Part1Test {

    @ParameterizedTest
    @MethodSource("inputs")
    void calculation(String input, int width, int height, int expected) {
        int result = doTheThing(input, width, height);
        assertThat(result).isEqualTo(expected);
    }

    private int doTheThing(String input, int width, int height) {
        int leastAmountOfZeros = Integer.MAX_VALUE;
        int layerIndex = 0;
        for (int i = 0; i < input.length(); i += (width * height)) {
            String substring = input.substring(i, i + width * height);
            int amountOfZeros = getAmountOf(substring, '0');
            if (amountOfZeros < leastAmountOfZeros) {
                layerIndex = i;
                leastAmountOfZeros = amountOfZeros;
            }
        }

        String layer = input.substring(layerIndex, layerIndex + width * height);
        return getAmountOf(layer, '1') * getAmountOf(layer, '2');
    }

    private int getAmountOf(String layer, char c) {
        return (int) layer.chars().filter(value -> value == c).count();
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("123456789012", 3, 2, 1),
                Arguments.of("120456781312", 3, 2, 2),
                Arguments.of("120456781212", 3, 2, 4),
                Arguments.of("120045600931212045678932", 3, 2, 0),
                Arguments.of("120045600931212045111122", 3, 2, 8)
        );
    }
}
