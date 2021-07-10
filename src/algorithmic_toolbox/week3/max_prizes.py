def nearest_sequential_sum(k: int) -> int:
    return int((((8 * k + 1) ** 0.5) - 1) // 2)


def sum_till(n: int) -> int:
    return (n * (n + 1)) // 2


if __name__ == '__main__':
    n = int(input())
    k = nearest_sequential_sum(n)
    
    print(k)
    for i in range(1, k):
        print(i, end=' ')
    print(k + n - sum_till(k))
