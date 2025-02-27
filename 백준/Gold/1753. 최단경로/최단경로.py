import heapq
import sys

input = sys.stdin.readline
INF = sys.maxsize

V, E = map(int, input().split())

start = int(input())
distance = [INF] * (V + 1)
graph = [[] for _ in range(V + 1)]
for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))


def solution(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


def print_answer():
    for i in range(1, V + 1):
        if distance[i] == INF:
            print("INF")
        else:
            print(distance[i])


if __name__ == "__main__":
    solution(start)
    print_answer()
