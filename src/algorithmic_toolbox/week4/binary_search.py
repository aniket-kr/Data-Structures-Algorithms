from typing import Any, Sequence


def bsearch(seq: Sequence, elmt: Any) -> int:
    lo = 0
    hi = len(seq) - 1
    while lo <= hi:
        mid = lo + (hi - lo) // 2
        if seq[mid] < elmt:
            lo = mid + 1
        elif seq[mid] > elmt:
            hi = mid - 1
        else:
            return mid
    
    return -1


if __name__ == '__main__':
    lst = [int(x) for x in input().split()][1:]
    elmts = [int(x) for x in input().split()][1:]

    for elmt in elmts:
        print(bsearch(lst, elmt), end=" ")
    print()
