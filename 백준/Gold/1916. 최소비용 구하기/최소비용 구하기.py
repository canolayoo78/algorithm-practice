import heapq
import sys

input = sys.stdin.readline
INF = sys.maxsize


def solution():
    N = int(input())
    M = int(input())
    graph = [[] for _ in range(N + 1)]
    distance = [INF] * (N + 1)
    for _ in range(M):
        u, v, w = map(int, input().split())
        graph[u].append((w, v))
    start, end = map(int, input().split())
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

    print(distance[end])


if __name__ == "__main__":
    solution()
