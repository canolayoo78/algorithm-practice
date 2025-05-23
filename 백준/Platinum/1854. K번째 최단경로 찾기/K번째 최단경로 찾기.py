import heapq
import sys

input = sys.stdin.readline
INF = sys.maxsize


def solution():
    n, m, k = map(int, input().split())
    graph = [[] for _ in range(n + 1)]
    distance = [[INF] * k for _ in range(n + 1)]

    for _ in range(m):
        u, v, w = map(int, input().split())
        graph[u].append((w, v))

    q = []
    heapq.heappush(q, (0, 1))
    distance[1][0] = 0

    while q:
        cost, now = heapq.heappop(q)
        for next_cost, next in graph[now]:
            if distance[next][k - 1] > cost + next_cost:
                distance[next][k - 1] = cost + next_cost
                distance[next].sort()
                heapq.heappush(q, (cost + next_cost, next))

    for i in range(1, n + 1):
        if distance[i][k - 1] == INF:
            print(-1)
        else:
            print(distance[i][k - 1])


if __name__ == "__main__":
    solution()
