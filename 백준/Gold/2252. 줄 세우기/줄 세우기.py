import sys
from collections import deque

input = sys.stdin.readline


def solution():
    N, M = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    in_degree = [0] * (N + 1)
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        in_degree[b] += 1

    ans = []
    q = deque([i for i in range(1, N + 1) if not in_degree[i]])

    while q:
        now = q.popleft()
        ans.append(now)
        for edge in graph[now]:
            in_degree[edge] -= 1
            if in_degree[edge] == 0:
                q.append(edge)

    print(" ".join(str(a) for a in ans))


if __name__ == "__main__":
    solution()
