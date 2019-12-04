defmodule Day2Part1Test do
  use ExUnit.Case

  for {input, output} <- [
        {"1,0,0,0,99", 2},
        {"1,0,0,2,99", 1},
        {"2,4,4,5,99,0", 2},
        {"2,2,3,0,99,0", 0},
        {"1,1,1,4,99,5,6,0,99", 30}
      ] do
    test "program #{input} should return #{output}" do
      assert Day2Part1.calculateForString(unquote(input)) == unquote(output)
    end
  end
end
