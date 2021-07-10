from typing import Any, Union


class NumberPiece:
    __slots__ = ['_num']

    def __init__(self, num: Union[int,str]):
        self._num = str(num)

    def __lt__(self, other: 'NumberPiece') -> bool:
        if not isinstance(other, NumberPiece):
            return NotImplemented

        pad_len = max(len(self.num), len(other.num))
        return self.num.ljust(pad_len, '9') < other.num.ljust(pad_len, '9')
    
    def __eq__(self, other: Any) -> bool:
        return isinstance(other, NumberPiece) and self.num == other.num

    def __le__(self, other: 'NumberPiece') -> bool:
        return self < other or self == other

    def __ge__(self, other: 'NumberPiece') -> bool:
        return self > other or self == other

    @property
    def num(self):
        return self._num


if __name__ == '__main__':
    n = input()  # not required in python
    pieces = [NumberPiece(x) for x in input().split()]

    pieces.sort(reverse=True)
    largest_number = ''.join((piece.num for piece in pieces)) 
    print(largest_number)
