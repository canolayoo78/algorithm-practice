import sys
from collections import deque

input = sys.stdin.readline


def solution(N, r, c):
    if N == 0:
        return 0
    return 2 * (r % 2) + (c % 2) + 4 * solution(N - 1, r // 2, c // 2)


if __name__ == "__main__":
    N, r, c = map(int, input().split())
    print(solution(N, r, c))
