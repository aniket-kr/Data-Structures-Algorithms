def fib():
    """Generates and returns terms of fibonacci series starting
    from 
    """
    yield 0
    yield 1

    terms = [0, 1]
    while True:
        terms[0], terms[1] = terms[1], terms[0] + terms[1]
        yield terms[1]


class FibModulo:
    def __init__(self, modulo: int):
        self._ptrn = []
        self._init_pattern(modulo)

    def _init_pattern(self, modulo: int):
        gen = fib()
        self._ptrn = [next(gen) % modulo, next(gen) % modulo]  # [0, 1]
        while len(self._ptrn) <= 2 or self._ptrn[-2:] != [0, 1]:
            self._ptrn.append(next(gen) % modulo)
        
        # remove redundant 0, 1
        self._ptrn.pop()
        self._ptrn.pop()

    def get_modulo(self, term: int) -> int:
        return self._ptrn[term % len(self._ptrn)]


if __name__ == '__main__':
    num, mod = map(int, input().split())
    fib_modulo = FibModulo(mod)
    print(fib_modulo.get_modulo(num))
