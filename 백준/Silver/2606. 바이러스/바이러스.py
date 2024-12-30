import sys
from collections import deque

input = sys.stdin.readline


def solution():
    N = int(input())
    V = int(input())
    graph = [[] for i in range(N + 1)]
    visited = [0] * (N + 1)

    for _ in range(V):
        node1, node2 = map(int, input().split())
        graph[node1] += [node2]
        graph[node2] += [node1]

    def dfs(start):
        visited[start] = 1
        for next_node in graph[start]:
            if not visited[next_node]:
                dfs(next_node)

    dfs(1)
    print(sum(visited) - 1)


solution()
