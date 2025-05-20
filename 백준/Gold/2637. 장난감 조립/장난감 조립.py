import sys
from collections import deque

input = sys.stdin.readline


def solution():
    N = int(input())
    M = int(input())
    graph = [[] for _ in range(N + 1)]
    in_degree = [0] * (N + 1)
    result = [0] * (N + 1)
    basic_units = [1] * (N + 1)

    for _ in range(M):
        x, y, k = map(int, input().split())
        graph[x].append((y, k))
        in_degree[y] += 1
        basic_units[x] = 0

    q = deque([N])
    result[N] = 1

    while q:
        now = q.popleft()
        for unit, k in graph[now]:
            result[unit] = result[now] * k + result[unit]
            in_degree[unit] -= 1
            if in_degree[unit] == 0:
                q.append(unit)

    for i in range(1, N):
        if basic_units[i]:
            print(i, result[i])


if __name__ == "__main__":
    solution()
