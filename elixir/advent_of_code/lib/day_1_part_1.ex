defmodule Day1Part1 do

    def calculateNeededFuelForModules(masses) do
        Enum.reduce(masses, 0, fn x, acc -> calculateNeededFuelForModule(x) + acc end)
    end

    def calculateNeededFuelForModule(mass) do
        trunc(mass / 3) - 2
    end
end
