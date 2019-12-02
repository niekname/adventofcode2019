package tv.mediagenix.aoc;

import java.util.List;

public class Day1Part2 {

    private List<Integer> masses;

    public Day1Part2(List<Integer> masses) {
        this.masses = masses;
    }

    public int calculateFuel() {
        return masses.stream()
                .mapToInt(this::calculateFuelForModule)
                .sum();
    }

    private int calculateFuelForModule(int mass) {
        int fuel = (mass / 3) - 2;
        if (fuel >= 0)
            return fuel + calculateFuelForModule(fuel);
        else
            return 0;
    }
}
