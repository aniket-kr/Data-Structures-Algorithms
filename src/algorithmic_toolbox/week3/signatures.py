from typing import List

class Line:

    def __init__(self, left: int, right: int):
        self.left = left
        self.right = right
    
    def __repr__(self):
        return f'Line({self.left}, {self.right})'


def find_points(lines: List[Line]) -> List[int]:
    points: List[int] = []

    min_right = -1
    for line in lines:
        # check if 'sweeper' has crossed previous min_right
        if min_right >= 0 and line.left > min_right:
            points.append(min_right)
            min_right = -1

        if min_right < 0 or line.right < min_right:
            min_right = line.right
    
    points.append(min_right)
    return points


if __name__ == '__main__':
    n = int(input())  # num of records
    lines = []
    for _ in range(n):
        lines.append(Line(*map(int, input().split())))  # left, right
    
    # sort Line according to their left endpoints
    lines.sort(key=lambda line: line.left)

    points = find_points(lines)
    print(len(points))
    for point in points:
        print(point, end=' ')
    print()
