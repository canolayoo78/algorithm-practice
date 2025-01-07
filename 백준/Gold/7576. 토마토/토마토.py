import sys
from collections import deque

input = sys.stdin.readline
steps = [(-1, 0), (1, 0), (0, -1), (0, 1)]
next = deque()


def solution():
    M, N = map(int, input().split())
    box = [list(map(int, input().split())) for _ in range(N)]

    if all(0 not in row for row in box):
        return 0

    for i in range(N):
        for j in range(M):
            if box[i][j] == 1:
                next.append((i, j))

    while next:
        n, m = next.popleft()

        for tm, tn in steps:
            nn, nm = n + tn, m + tm
            if nm in range(M) and nn in range(N) and box[nn][nm] == 0:
                next.append((nn, nm))
                box[nn][nm] = box[n][m] + 1

    max_days = 0
    for row in box:
        if 0 in row:
            return -1
        max_days = max(max_days, max(row))

    return max_days - 1


if __name__ == "__main__":
    print(solution())
