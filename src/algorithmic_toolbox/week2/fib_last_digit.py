def fib_last_digit(n: int) -> int:
    if n < 2:
        return n

    terms = [0, 1]  # last digit terms
    for _ in range(2, n + 1):
        new_term = (terms[0] + terms[1]) % 10
        terms[0], terms[1] = terms[1], new_term
    return terms[1]


if __name__ == '__main__':
    n = int(input())
    print(fib_last_digit(n))