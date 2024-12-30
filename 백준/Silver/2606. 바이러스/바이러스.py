import sys
from collections import deque

input = sys.stdin.readline


def solution():
    N = int(input())
    V = int(input())
    graph = [[] for i in range(N + 1)]
    visited = [0] * (N + 1)

    for i in range(V):
        node1, node2 = map(int, input().split())
        graph[node1] += [node2]
        graph[node2] += [node1]

    visited[1] = 1
    queue = deque([1])

    while queue:
        start_node = queue.pop()
        for next_node in graph[start_node]:
            if visited[next_node] == 0:
                queue.append(next_node)
                visited[next_node] = 1

    print(sum(visited) - 1)


solution()
