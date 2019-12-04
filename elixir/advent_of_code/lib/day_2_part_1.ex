defmodule Day2Part1 do

    def calculateForString(stringInput) do
        input = Enum.map(String.split(stringInput, ","), fn x -> Integer.parse(x) |> elem(0) end)
        calculate(input)
    end

  def calculate(input) do
    calculateNextOpcode(input, 0)
  end

  def calculateNextOpcode(input, currentStartIndex) do
    [opcode | tail] = Enum.slice(input, currentStartIndex, currentStartIndex + 5)

    if (opcode == 99) do
        hd(input)
    else
        [a, b, outputPosition | _] = tail

        calc = case opcode do
            1 -> Enum.at(input, a) + Enum.at(input, b)
            2 -> Enum.at(input, a) * Enum.at(input, b)
        end

        output =
        input
        |> Enum.with_index()
        |> Enum.map(fn {x, i} ->
            case i do
            ^outputPosition -> calc
            _ -> x
            end
        end)
        
        calculateNextOpcode(output, currentStartIndex + 4)
    end
  end
end
