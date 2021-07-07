from typing import List


def max_product(nums: List[int]) -> int:
    nums.sort(reverse=True)
    return nums[0] * nums[1]


if __name__ == '__main__':
    num_elmts = input()
    nums = [int(token) for token in input().split()]
    print(max_product(nums))
