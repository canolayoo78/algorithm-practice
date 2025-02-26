import sys
from collections import deque

MAX = 10**5
visited = [-1] * (MAX + 1)
input = sys.stdin.readline


def solution(N, K):
    q = deque([N])
    visited[N] = 0
    while q:
        now = q.popleft()
        if now == K:
            return visited[now]
        if 0 <= now - 1 <= 100000 and visited[now - 1] == -1:
            visited[now - 1] = visited[now] + 1
            q.append(now - 1)
        if 0 <= now * 2 <= 100000 and visited[now * 2] == -1:
            visited[now * 2] = visited[now] + 0
            q.appendleft(now * 2)
        if 0 <= now + 1 <= 100000 and visited[now + 1] == -1:
            visited[now + 1] = visited[now] + 1
            q.append(now + 1)


if __name__ == "__main__":
    N, K = map(int, input().split())
    print(solution(N, K))
