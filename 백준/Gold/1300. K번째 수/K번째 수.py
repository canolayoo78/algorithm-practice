import sys
from collections import deque

input = sys.stdin.readline


def solution():
    N = int(input())
    K = int(input())

    start = 0
    end = K
    ans = 0

    while start <= end:
        middle = (start + end) // 2
        cnt = 0
        for i in range(1, N + 1):
            cnt += min(middle // i, N)
        if cnt >= K:
            ans = middle
            end = middle - 1
        else:
            start = middle + 1
    print(ans)


if __name__ == "__main__":
    solution()
