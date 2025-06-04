import math
import sys
from collections import deque

sys.setrecursionlimit(10**6)
input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    def bfs(node):
        queue = deque([node])
        visited[node] = 1

        while queue:
            now = queue.popleft()
            for next in tree[now]:
                if not visited[next]:
                    visited[next] = 1
                    queue.append(next)
                    parents[next] = now
                    depths[next] = depths[now] + 1

    def find_LCA(a, b):
        if depths[a] > depths[b]:
            a, b = b, a

        for i in range(k, -1, -1):
            if pow(2, i) <= depths[b] - depths[a]:
                if depths[a] <= depths[p[i][b]]:
                    b = p[i][b]

        for i in range(k, -1, -1):
            if a == b:
                break
            if p[i][a] != p[i][b]:
                a = p[i][a]
                b = p[i][b]

        LCA = a
        if a != b:
            LCA = p[0][LCA]

        return LCA

    N = int(input())
    tree = [[] for _ in range(N + 1)]
    visited = [0] * (N + 1)
    parents = [0] * (N + 1)
    depths = [0] * (N + 1)
    for _ in range(N - 1):
        s, e = map(int, input().split())
        tree[s].append(e)
        tree[e].append(s)

    bfs(1)
    max_depth = max(depths)
    k = int(math.log2(max_depth))
    p = [[0] * (N + 1) for _ in range(k + 1)]
    p[0] = parents[:]
    for i in range(k):
        for j in range(1, N + 1):
            p[i + 1][j] = p[i][p[i][j]]
    M = int(input())
    mydict = dict()
    for _ in range(M):
        a, b = map(int, input().split())
        if a > b:
            a, b = b, a
        if not mydict.get((a, b), 0):
            mydict[(a, b)] = find_LCA(a, b)
        print(mydict.get((a, b)))


if __name__ == "__main__":
    solution()
