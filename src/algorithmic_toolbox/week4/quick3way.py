from typing import List, MutableSequence
import random


def quicksort(lst: MutableSequence):
    random.shuffle(lst)
    _quicksort(lst, 0, len(lst) - 1)


def _quicksort(lst: MutableSequence, lo: int, hi: int):
    if hi <= lo:
        return

    lt, gt = lo, hi
    pivot = lst[lo]
    i = lo + 1
    while i <= gt:
        if lst[i] < pivot:
            lst[i], lst[lt] = lst[lt], lst[i]
            lt += 1
            i += 1
        
        elif lst[i] > pivot:
            lst[i], lst[gt] = lst[gt], lst[i]
            gt -= 1
        
        else:
            i += 1
    
    _quicksort(lst, lo, lt - 1)
    _quicksort(lst, gt + 1, hi)


if __name__ == '__main__':
    input()  # size of sequence not required
    nums: List[int] = list(map(int, input().split()))
    
    quicksort(nums)
    
    for num in nums:
        print(num, end=' ')
    print()
