# Finds the Greatest Common Divisor (GCD, or HCF) using
# euclidean algorithm


def _gcd(a : int, b: int) -> int:
    """Returns GCD(a, b), such that 'a' must always be greater
    than 'b'.
    """
    if b == 0:
        return a
    return _gcd(b, a % b)


def gcd(a: int, b: int) -> int:
    return _gcd(a, b) if a > b else _gcd(b, a)


if __name__ == '__main__':
    a, b = [int(x) for x in input().split()]
    print(gcd(a, b))
