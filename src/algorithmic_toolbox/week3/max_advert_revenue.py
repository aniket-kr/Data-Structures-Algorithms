from typing import List


def get_max_revenue(profits: List[int], clicks: List[int]) -> int:
    profits.sort()
    clicks.sort()
    
    total = 0
    for i in range(len(profits)):
        total += profits[i] * clicks[i]
    
    return total


if __name__ == '__main__':
    n = input()  # not required for Python
    profits = [int(x) for x in input().split()]
    clicks = [int(x) for x in input().split()]

    print(get_max_revenue(profits, clicks))
