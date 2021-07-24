from typing import List


def change(target: int, coins: List[int]) -> int:
    table = [-1] * (target + 1)
    table[0] = 0  # base case

    for i in range(target + 1):
        if table[i] != -1:
            for coin in coins:
                res = i + coin
                potential_change = table[i] + 1
                if res <= target:
                    if table[res] == -1:
                        table[res] = potential_change
                    elif table[res] > potential_change:
                        table[res] = potential_change

    return table[target]


if __name__ == '__main__':
    target = int(input())
    print(change(target, [1, 3, 4]))
