import heapq
import sys

input = sys.stdin.readline
INF = sys.maxsize


def solution():
    V, E = map(int, input().split())
    graph = [[] for _ in range(V + 1)]
    distance = [INF] * (V + 1)

    def dijkstra(start):
        distance[start] = 0
        q = []
        heapq.heappush(q, (0, start))

        while q:
            d, now = heapq.heappop(q)
            if distance[now] < d:
                continue
            for d, next in graph[now]:
                if distance[next] > distance[now] + d:
                    distance[next] = distance[now] + d
                    heapq.heappush(q, (distance[now] + d, next))

    for _ in range(E):
        u, v, w = map(int, input().split())
        graph[u].append((w, v))
        graph[v].append((w, u))

    must_visit = list(map(int, input().split()))
    paths = [0, 0]

    dijkstra(1)
    paths[0], paths[1] = distance[must_visit[0]], distance[must_visit[1]]

    for i in range(2):
        if paths[i] != INF:
            distance = [INF] * (V + 1)
            dijkstra(must_visit[i])
            paths[i] += distance[must_visit[(i + 1) % 2]]

    for i in range(2):
        if paths[i] != INF:
            distance = [INF] * (V + 1)
            dijkstra(must_visit[(i + 1) % 2])
            paths[i] += distance[-1]

    print(-1 if min(paths) >= INF else min(paths))


if __name__ == "__main__":

    solution()
