export const calculateRequiredFuel = (mass: number) => {
  return mass ? Math.floor(mass / 3) - 2 : 0;
};

export const calculateFuelFromArray = (masses: number[]) => {
  let total: number = 0;
  masses.map(mass => (total += calculateRequiredFuel(mass)));
  return total;
};
