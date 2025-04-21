import heapq
import sys

sys.setrecursionlimit(10000)

input = sys.stdin.readline
# print = sys.stdout.write


def solution():
    N = int(input())
    negative_nums = []
    positive_nums = []
    ans = 0

    for _ in range(N):
        num = int(input())
        if num > 1:
            positive_nums.append(num)
        elif num <= 0:
            negative_nums.append(num)
        else:
            ans += 1

    negative_nums.sort()
    positive_nums.sort(reverse=True)

    for i in range(0, len(positive_nums), 2):
        if i + 1 >= len(positive_nums):
            ans += positive_nums[i]
        else:
            ans += positive_nums[i] * positive_nums[i + 1]

    for i in range(0, len(negative_nums), 2):
        if i + 1 >= len(negative_nums):
            ans += negative_nums[i]
        else:
            ans += negative_nums[i] * negative_nums[i + 1]
    print(ans)


if __name__ == "__main__":
    solution()
