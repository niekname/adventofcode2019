defmodule Day8Part2Test do
  use ExUnit.Case

  test "get result for layer with least zeroes" do
    assert Day8Part2.calculate("0222112222120000", 2, 2) == "0110"
  end
end
