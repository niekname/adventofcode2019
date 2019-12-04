# AdventOfCode

**TODO: Add description**

## Installation

If [available in Hex](https://hex.pm/docs/publish), the package can be installed
by adding `advent_of_code` to your list of dependencies in `mix.exs`:

```elixir
def deps do
  [
    {:advent_of_code, "~> 0.1.0"}
  ]
end
```

Documentation can be generated with [ExDoc](https://github.com/elixir-lang/ex_doc)
and published on [HexDocs](https://hexdocs.pm). Once published, the docs can
be found at [https://hexdocs.pm/advent_of_code](https://hexdocs.pm/advent_of_code).

## Auto-run tests on save + some extra config that comes in handy when doing TDD

`mix test.watch --max-failures 1 --seed 0 --stale --trace`

`--stale` executes only tests for source and test files which are changed.
`--max-failures 1` stops execution after first failing test.
`--trace` prints names of tests instead of dots, so you can see which tests are executed in more descriptive way.
`--seed 0` forces tests to execute in same order they are mentioned in source file, so that you will have predictable consecutive runs of the tests.

Want to learn more about running tests using Elixir? See: https://medium.com/learn-elixir/supercharge-your-elixir-unit-testing-skills-in-10-minutes-a9c76d96e3b6
