defmodule Day8Part1 do
    def calculate(input, width, height) do
      intArrInput = String.graphemes(input)
      |> Enum.map(fn x -> Integer.parse(x) |> elem(0) end)
      
      layers = Enum.chunk_every(intArrInput, width * height)
      
      layers
      |> Enum.map(fn layer -> 
        zeroDigits = layer
        |> Enum.filter(fn x -> x == 0 end)
        |> length

        oneDigits = layer
        |> Enum.filter(fn x -> x == 1 end)
        |> length

        twoDigits = layer
        |> Enum.filter(fn x -> x == 2 end)
        |> length
        {zeroDigits, oneDigits * twoDigits}
      end)
      |> Enum.min_by(fn x -> elem(x, 0) end)
      |> elem(1)
    end
  end
  