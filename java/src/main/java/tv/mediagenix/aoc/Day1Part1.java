package tv.mediagenix.aoc;

import java.util.List;

public class Day1Part1 {

    private List<Integer> masses;

    public Day1Part1(List<Integer> masses) {
        this.masses = masses;
    }

    public int calculateFuel() {
        return masses.stream()
                .mapToInt(singleMass -> (singleMass / 3) - 2)
                .sum();
    }
}
