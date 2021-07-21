from typing import List


def find_majority(lst : List[int], lo: int, hi: int) -> int:
    if (hi <= lo):
        return lst[lo]
    
    mid = lo + (hi - lo) // 2
    maj1 = find_majority(lst, lo, mid)
    maj2 = find_majority(lst, mid + 1, hi)
    return _merge(lst, maj1, maj2, lo, hi)


def _merge(lst: List[int], m1: int, m2: int, lo: int, hi: int) -> int:
    m1_count = m2_count = 0
    maj_count = (hi - lo + 1) // 2 + 1

    for i in range(lo, hi + 1):
        if lst[i] == m1:
            m1_count += 1
        elif lst[i] == m2:
            m2_count += 1
    
    if m1_count >= maj_count:
        return m1
    elif m2_count >= maj_count:
        return m2
    else:
        return -1


if __name__ == '__main__':
    input()  # size not required
    nums: List[int] = list(map(int, input().split()))
    maj = find_majority(nums, 0, len(nums) - 1)

    print(0 if maj <= -1 else 1)
