import sys

input = sys.stdin.readline


def solution():
    N, M = map(int, input().split())
    graph = [[] for _ in range(N)]
    for _ in range(M):
        h1, h2 = map(int, input().split())
        graph[h1].append(h2)
        graph[h2].append(h1)
    visited = [False] * N
    arrive = False

    def dfs(now, depth):
        nonlocal arrive
        if depth == 5 or arrive is True:
            arrive = True
            return
        visited[now] = True
        for i in graph[now]:
            if not visited[i]:
                dfs(i, depth + 1)
        visited[now] = False

    for i in range(N):
        dfs(i, 1)
        if arrive:
            break
    if arrive:
        print(1)
    else:
        print(0)


if __name__ == "__main__":
    solution()
