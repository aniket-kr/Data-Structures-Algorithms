from typing import Callable, List


IntOper = Callable[[int], int]


def best_opers(target: int, opers: List[IntOper]) -> List[IntOper]:
    table = [None] * (target + 1)
    table[1] = []  # starts at 1 - base case

    for i in range(1, target + 1):
        if table[i] is not None:
            for oper in opers:
                res = oper(i)
                potential_opers = [*table[i], oper]
                if res <= target and (table[res] is None or len(table[res]) > len(potential_opers)):
                    table[res] = potential_opers

    return table[target]


if __name__ == '__main__':
    opers = [
        lambda x: x + 1,
        lambda x: x * 2,
        lambda x: x * 3
    ]

    target = int(input())
    operations = best_opers(target, opers)
    
    print(len(operations))
    
    result = 1
    for oper in operations:
        print(result, end=' ')
        result = oper(result)
    print(result)