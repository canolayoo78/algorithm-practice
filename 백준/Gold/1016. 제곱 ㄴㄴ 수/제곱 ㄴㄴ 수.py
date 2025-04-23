import math
import sys

input = sys.stdin.readline


def solution():
    Min, Max = map(int, input().split())
    check = [True] * (Max - Min + 1)

    for i in range(2, int(Max**0.5) + 1):
        pow = i**2
        start_index = math.ceil(Min / pow)

        for j in range(start_index, int(Max / pow) + 1):
            check[j * pow - Min] = False

    print(sum(check))


if __name__ == "__main__":
    solution()
