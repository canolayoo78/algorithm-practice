import sys
from collections import deque

input = sys.stdin.readline
# wirte = sys.stdout.write
INF = sys.maxsize


def solution():
    n, m = map(int, input().split())
    ans = [0] * (n + 1)
    graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)

    def bfs(n):
        q = deque()
        q.append(n)
        visited[n] = 1
        while q:
            now = q.popleft()
            for next in graph[now]:
                if not visited[next]:
                    q.append(next)
                    visited[next] = 1
                    ans[next] += 1

    for i in range(1, n + 1):
        visited = [0] * (n + 1)
        bfs(i)

    max_hacked = max(ans)
    for i in range(1, n + 1):
        if max_hacked == ans[i]:
            print(i, end=" ")


if __name__ == "__main__":
    solution()
