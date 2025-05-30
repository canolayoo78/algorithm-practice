import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline
write = sys.stdout.write


def solution():
    def dfs(now):
        visited[now] = True
        for next in graph[now]:
            if not visited[next]:
                ans[next] = now
                dfs(next)

    n = int(input())
    graph = [[] for _ in range(n + 1)]
    visited = [0] * (n + 1)
    ans = [0] * (n + 1)
    for _ in range(n - 1):
        parent, child = map(int, input().split())
        graph[parent].append(child)
        graph[child].append(parent)

    dfs(1)

    write("\n".join(str(a) for a in ans[2:]))


if __name__ == "__main__":
    solution()
