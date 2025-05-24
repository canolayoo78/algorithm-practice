import sys
from collections import deque

input = sys.stdin.readline
INF = sys.maxsize


def solution():
    n, start_city, end_city, m = map(int, input().split())
    edges = []
    distances = [INF] * n
    q = deque()
    visited = [0 for i in range(n)]
    for _ in range(m):
        start, end, weight = map(int, input().split())
        edges.append((start, end, weight))

    profits = list(map(int, input().split()))

    distances[start_city] = -profits[start_city]

    for _ in range(n - 1):
        for start, end, weight in edges:
            if (
                distances[start] != INF
                and distances[end] > distances[start] + weight - profits[end]
            ):
                distances[end] = distances[start] + weight - profits[end]

    def dfs(start):
        q.append(start)
        visited[start] = 1
        while q:
            now = q.popleft()
            for start, end, weight in edges:
                if start == now and not visited[end]:
                    q.append(end)
                    visited[end] = 1
        if visited[end_city]:
            return True
        else:
            return False

    for start, end, weight in edges:
        if (
            distances[start] != INF
            and distances[end] > distances[start] + weight - profits[end]
        ):
            if dfs(start):
                print("Gee")
                return

    print("gg" if distances[end_city] == INF else -(distances[end_city]))


if __name__ == "__main__":
    solution()
