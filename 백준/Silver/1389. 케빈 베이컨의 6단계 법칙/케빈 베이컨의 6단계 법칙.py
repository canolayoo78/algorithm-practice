import sys
from collections import deque

sys.setrecursionlimit(10**6)
input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    def bfs(start):
        q = deque([(start, 0)])
        visited = [0] * (n + 1)
        distance = 0
        while q:
            now, dist = q.popleft()
            visited[now] = 1
            distance += dist
            for next in graph[now]:
                if not visited[next]:
                    q.append((next, dist + 1))
                    visited[next] = 1
        return distance

    n, m = map(int, input().split())
    graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    min_index = 0
    min_sum = INF
    for i in range(1, n + 1):
        now_sum = bfs(i)
        if now_sum < min_sum:
            min_index = i
            min_sum = now_sum

    write(str(min_index))


if __name__ == "__main__":
    solution()
