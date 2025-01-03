import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

visited = [False] * 100001
seek = deque()
t = 0
seek.append((N, t))


def solution():
    while True:
        N, t = seek.popleft()
        if N == K:
            break

        if N > 0 and not visited[N - 1]:
            seek.append((N - 1, t + 1))
            visited[N - 1] = True

        if N < 100000 and not visited[N + 1]:
            seek.append((N + 1, t + 1))
            visited[N + 1] = True

        if N <= 50000 and not visited[N * 2]:
            seek.append((N * 2, t + 1))
            visited[N * 2] = True
    print(t)


if __name__ == "__main__":
    solution()
