import sys

input = sys.stdin.readline
INF = sys.maxsize


def solution():
    n, m = map(int, input().split())
    edges = []
    distances = [INF] * (n + 1)
    distances[1] = 0
    for _ in range(m):
        start, end, weight = map(int, input().split())
        edges.append((start, end, weight))

    for _ in range(n - 1):
        for start, end, weight in edges:
            if distances[start] != INF and distances[end] > distances[start] + weight:
                distances[end] = distances[start] + weight

    for start, end, weight in edges:
        if distances[start] != INF and distances[end] > distances[start] + weight:
            print(-1)
            return

    for i in range(2, n + 1):
        if distances[i] == INF:
            print(-1)
        else:
            print(distances[i])


if __name__ == "__main__":
    solution()
