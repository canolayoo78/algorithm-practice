import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N + 1)]
visited = [0] * (N + 1)
ans = [0] * (N + 1)

for _ in range(N - 1):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)


def dfs(start):
    visited[start] = 1

    for next_node in graph[start]:
        if not visited[next_node]:
            ans[next_node] = start
            dfs(next_node)


if __name__ == "__main__":
    dfs(1)
    print("\n".join(str(answer) for answer in ans[2:]))
