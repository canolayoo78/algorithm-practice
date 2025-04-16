import sys

sys.setrecursionlimit(10**4)
input = sys.stdin.readline


def solution():
    N, M = map(int, input().split())

    graph = [[] for _ in range(N + 1)]
    visited = [0] * (N + 1)

    for _ in range(M):
        node1, node2 = map(int, input().split())
        graph[node1] += [node2]
        graph[node2] += [node1]

    def dfs(start):
        visited[start] = 1
        for next_node in graph[start]:
            if not visited[next_node]:
                dfs(next_node)

    ans = 0
    for i in range(1, N + 1):
        if not visited[i]:
            dfs(i)
            ans += 1
    print(ans)


if __name__ == "__main__":
    solution()
