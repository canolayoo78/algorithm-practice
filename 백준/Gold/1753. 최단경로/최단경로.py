import heapq
import sys

input = sys.stdin.readline
INF = sys.maxsize


def solution():
    V, E = map(int, input().split())
    start = int(input())
    distance = [INF] * (V + 1)
    graph = [[] for _ in range(V + 1)]

    for _ in range(E):
        u, v, w = map(int, input().split())
        graph[u].append((w, v))

    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        d, now = heapq.heappop(q)
        if distance[now] < d:
            continue
        for d, next in graph[now]:
            if distance[next] > distance[now] + d:
                distance[next] = distance[now] + d
                heapq.heappush(q, (distance[now] + d, next))

    for i in range(1, V + 1):
        if distance[i] == INF:
            print("INF")
        else:
            print(distance[i])


if __name__ == "__main__":
    solution()
