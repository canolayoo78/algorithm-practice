import math
import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    N = int(input()) // 3

    if N < 3:
        write("0")
    else:
        write(str(math.comb(N - 1, 2)))


if __name__ == "__main__":
    solution()
