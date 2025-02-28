import heapq
import sys

input = sys.stdin.readline
INF = sys.maxsize

N, M, start = map(int, input().split())

time_togo = [INF] * (N + 1)
time_comeback = [INF] * (N + 1)

graph_togo = [[] for _ in range(N + 1)]
graph_comeback = [[] for _ in range(N + 1)]

for _ in range(M):
    s, e, v = map(int, input().split())
    graph_togo[s].append((v, e))
    graph_comeback[e].append((v, s))


def dijkstra(start, time, graph):
    q = []
    heapq.heappush(q, (0, start))
    time[start] = 0

    while q:
        t, now = heapq.heappop(q)
        if time[now] < t:
            continue
        for i in graph[now]:
            cost = t + i[0]
            if cost < time[i[1]]:
                time[i[1]] = cost
                heapq.heappush(q, (cost, i[1]))

    return time


def solution():
    global time_togo, time_comeback
    time_togo = dijkstra(start, time_togo, graph_togo)
    time_comeback = dijkstra(start, time_comeback, graph_comeback)
    max = 0
    for i in range(1, N + 1):
        round_trip = time_togo[i] + time_comeback[i]
        if round_trip > max:
            max = round_trip
    print(max)


if __name__ == "__main__":
    solution()
