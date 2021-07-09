from typing import List

DENOMINATIONS = [10, 5, 1]


def count_coins(money: int, denominations: List[int]) -> int:
    total_coins = 0
    for coin_value in denominations:
        if money == 0:
            break

        total_coins += money // coin_value
        money = money % coin_value
    
    return total_coins


if __name__ == '__main__':
    money = int(input())
    print(count_coins(money, DENOMINATIONS))
