defmodule Day1Part2Test do
    use ExUnit.Case
  
    test "a module with a mass of 12 needs 2 fuel" do
        assert Day1Part2.calculate(12) == 2
    end

    test "a module with a mass of 14 needs 2 fuel" do
        assert Day1Part2.calculate(14) == 2
    end

    test "a module with a mass of 1969 needs 654 fuel" do
        assert Day1Part2.calculate(1969) == 966
    end

    test "modules with a mass of 14 and 1969 needs 656 fuel in total" do
        assert Day1Part2.calculateNeededFuelForModules([14, 1969]) == 2 + 966
    end
  end
  