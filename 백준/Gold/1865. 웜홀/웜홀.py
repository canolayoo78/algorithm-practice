import sys
from collections import deque

input = sys.stdin.readline
write = sys.stdout.write
read = sys.stdin.buffer.read
sys.setrecursionlimit(10**6)
INF = sys.maxsize


def solution():
    N, M, W = map(int, input().split())
    edges = []
    dist = [0] * (N + 1)
    for _ in range(M):
        s, e, t = map(int, input().split())
        edges.append((s, e, t))
        edges.append((e, s, t))

    for _ in range(W):
        s, e, t = map(int, input().split())
        edges.append((s, e, -t))

    for i in range(N - 1):
        updated = False
        for s, e, t in edges:
            if dist[s] > dist[e] + t:
                dist[s] = dist[e] + t
                updated = True
        if not updated:
            break

    for s, e, t in edges:
        if dist[s] > dist[e] + t:
            return True
    return False


if __name__ == "__main__":
    T = int(input())
    ans = []
    for _ in range(T):
        ans.append("YES" if solution() else "NO")
    write("\n".join(ans))
