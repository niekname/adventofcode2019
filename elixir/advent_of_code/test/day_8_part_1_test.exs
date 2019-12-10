defmodule Day8Part1Test do
  use ExUnit.Case

  test "get result for layer with least zeroes" do
    assert Day8Part1.calculate("000122222210", 3, 2) == 4
  end

end
