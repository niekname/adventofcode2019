defmodule Day1Part2Test do
  use ExUnit.Case

  for {input, output} <- [{12, 2}, {14, 2}, {1969, 966}] do
    test "a module with a mass of #{input} needs #{output} fuel" do
      assert Day1Part2.calculate(unquote(input)) == unquote(output)
    end
  end

  test "modules with a mass of 14 and 1969 needs 2 + 966 fuel in total" do
    assert Day1Part2.calculateNeededFuelForModules([14, 1969]) == 2 + 966
  end
end
