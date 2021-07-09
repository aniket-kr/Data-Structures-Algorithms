def gcd(a: int , b: int) -> int:
    if b == 0:
        return a
    return gcd(b, a % b)


def lcm(a: int, b: int) -> int:
    hcf = gcd(a, b) if a > b else gcd(b, a)
    return (a * b) // hcf


if __name__ == '__main__':
    a, b = [int(x) for x in input().split()]
    print(lcm(a, b))
