from typing import List


class Loot:
    __slots__ = ['_mass', '_total_value']

    def __init__(self, total_value: int, mass: int):
        self._mass = mass
        self._total_value = total_value

    @property
    def mass(self) -> int:
        return self._mass

    @property
    def value(self) -> int:
        return self._total_value

    def calc_value(self, mass: int) -> float:
        return self.value / self.mass * mass

    def __repr__(self) -> str:
        price_per_unit = round(self.value / self.mass, 4)
        return f'Loot({self.mass} units @ {price_per_unit}/unit)'


if __name__ == '__main__':
    num_items, capacity = map(int, input().split())

    items: List[Loot] = []
    for _ in range(num_items):
        items.append(Loot(*map(int, input().split())))

    items.sort(key=lambda loot: loot.value / loot.mass, reverse=True)

    total_value = 0
    for loot in items:
        if capacity >= loot.mass:
            capacity -= loot.mass
            total_value += loot.value
        else:
            total_value += loot.calc_value(capacity)
            capacity = 0
            break

    print(round(float(total_value), 4))
