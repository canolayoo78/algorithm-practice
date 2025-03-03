import sys
from collections import deque

input = sys.stdin.readline


def dfs(start):
    visited_dfs[start] = True
    print(start, end=" ")
    for next in graph[start]:
        if not visited_dfs[next]:
            dfs(next)


def bfs(start):
    q = deque([start])
    visited_bfs[start] = True
    while q:
        start = q.popleft()
        print(start, end=" ")
        for next in graph[start]:
            if not visited_bfs[next]:
                visited_bfs[next] = True
                q.append(next)


N, M, start = map(int, input().split())
graph = [[] for _ in range(N + 1)]
visited_dfs = [False] * (N + 1)
visited_bfs = [False] * (N + 1)

for _ in range(M):
    s, e = map(int, input().split())
    graph[s].append((e))
    graph[e].append((s))

for i in graph:
    i.sort()

if __name__ == "__main__":
    dfs(start)
    print()
    bfs(start)
