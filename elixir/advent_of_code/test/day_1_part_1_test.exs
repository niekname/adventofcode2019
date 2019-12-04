defmodule Day1Part1Test do
    use ExUnit.Case

    for {input, output} <- [{12, 2}, {14, 2}, {1969, 654}] do
        test "a module with a mass of #{input} needs #{output} fuel" do
            assert Day1Part1.calculateNeededFuelForModule(unquote(input)) == unquote(output)
        end
    end

    test "modules with a mass of 14 and 1969 needs 656 fuel in total" do
        assert Day1Part1.calculateNeededFuelForModules([14, 1969]) == 656
    end
  end
  