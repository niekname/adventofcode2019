package tv.mediagenix.aoc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Day8Part2Test {

    @ParameterizedTest
    @MethodSource("inputs")
    void calculation(String input, int width, int height, String expected) {
        String result = doTheOtherThing(input, width, height);
        assertThat(result).isEqualTo(expected);
    }

    private String doTheOtherThing(String input, int width, int height) {
        int layerLength = width * height;
        String result = "";
        here:
        for (int i = 0; i < layerLength; i++) {
            for (int j = i; j < input.length(); j += layerLength) {
                char charOfInterest = input.charAt(j);
                if (charOfInterest != '2') {
                    result += charOfInterest;
                    continue here;
                }
            }
        }

        return result;
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("0", 1, 1, "0"),
                Arguments.of("01", 1, 1, "0"),
                Arguments.of("10", 1, 1, "1"),
                Arguments.of("20", 1, 1, "0"),
                Arguments.of("2210", 1, 1, "1"),
                Arguments.of("0210", 2, 1, "00"),
                Arguments.of("0222112222120000", 2, 2, "0110")
        );
    }
}
