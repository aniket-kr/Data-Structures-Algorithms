def fib(n: int) -> int:
    if n < 2:
        return n

    terms = [0, 1]
    for _ in range(2, n + 1):
        new_term = terms[0] + terms[1]
        terms[0], terms[1] = terms[1], new_term
    return terms[1]


if __name__ == '__main__':
    n = int(input())
    print(fib(n))