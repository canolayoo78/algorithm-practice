import bisect
import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    num = list(map(int, input().split()))
    tails = []

    for i in range(N):
        pos = bisect.bisect_left(tails, num[i])
        if pos == len(tails):
            tails.append(num[i])
        else:
            tails[pos] = num[i]

    print(len(tails))


if __name__ == "__main__":
    solution()
