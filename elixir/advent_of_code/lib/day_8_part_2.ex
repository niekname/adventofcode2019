defmodule Day8Part2 do
  def calculate(input, width, height) do
    intArrInput = String.graphemes(input)
    |> Enum.map(fn x -> Integer.parse(x) |> elem(0) end)
    
    layers = Enum.chunk_every(intArrInput, width * height)
    
    layers

    0..(width*height)-1
    |> Enum.map(fn elem ->
      layers
      |> Enum.map(fn layer -> Enum.at(layer, elem) end)
      |> Enum.find(fn pixel -> pixel != 2 end)
    end)
    |> Enum.join("")
  end
end
  