import heapq
import sys

input = sys.stdin.readline
INF = sys.maxsize


def solution():
    N = int(input())
    M = int(input())
    graph = [[] for _ in range(N + 1)]
    distance = [INF] * (N + 1)
    visited = [0] * (N + 1)
    for _ in range(M):
        u, v, w = map(int, input().split())
        graph[u].append((w, v))
    start, end = map(int, input().split())

    distance[start] = 0

    for _ in range(N):
        min_index = -1
        min_dist = INF
        for i in range(1, N + 1):
            if not visited[i] and distance[i] < min_dist:
                min_dist = distance[i]
                min_index = i

        if min_index == -1:
            break

        visited[min_index] = 1

        for d, next in graph[min_index]:
            if not visited[next] and distance[next] > distance[min_index] + d:
                distance[next] = distance[min_index] + d

    print(distance[end])


if __name__ == "__main__":
    solution()
