defmodule Day1Part2 do

    def calculateNeededFuelForModules(masses) do
        Enum.reduce(masses, 0, fn x, acc -> calculate(x) + acc end)
    end

    def calculate(mass) do
        calc(0, mass)
    end

    def calc(a, b) do
        x = trunc(b / 3) - 2
        case x do
            _ when x <= 0 -> a
            _ -> calc(a + x, x)
        end
    end
end
