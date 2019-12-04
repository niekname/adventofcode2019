export const calculateRequiredFuel = (mass: number) => {
  let total: number = 0;
  let calculated = Math.floor(mass / 3) - 2;
  while (calculated > 0) {
    total += calculated;
    calculated = Math.floor(calculated / 3) - 2;
  }
  return total;
};

export const calculateFuelFromArray = (masses: number[]) => {
  let total: number = 0;
  masses.map(mass => (total += calculateRequiredFuel(mass)));
  return total;
};
