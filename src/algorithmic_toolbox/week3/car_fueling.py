from typing import List, TypeVar

T = TypeVar('T')
def floor(lst: List[T], val: T) -> T:
    start = 0
    end = len(lst) - 1

    while start <= end:
        mid = (start  + end) // 2

        if lst[mid] < val:
            start = mid + 1
        elif lst[mid] > val:
            end = mid - 1
        else:
            return lst[mid]
    
    mid = (start + end) // 2
    return lst[mid] if lst[mid] < val else lst[mid - 1]

def calc_refuel(max_range: int, stations: List[int]):
    pos = 0
    stops = 0

    while True:
        reach = pos + max_range
        new_pos = floor(stations, reach)

        if pos == new_pos:
            return -1  # impossible
        pos = new_pos
        
        if new_pos >= stations[-1]:
            break
        stops += 1

    return stops


if __name__ == '__main__':
    dest = int(input())
    max_range = int(input())
    input()
    stations: List[int] = [int(x) for x in input().split()]  # sorted

    stations.insert(0, 0)  # start at position 0
    stations.append(dest)

    print(calc_refuel(max_range, stations))
