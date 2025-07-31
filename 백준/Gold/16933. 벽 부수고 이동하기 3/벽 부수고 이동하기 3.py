import sys
from collections import deque

input = sys.stdin.readline


def solution():
    def try_push(nx, ny, nk, dist, nd):
        if nk < visited[nd][nx][ny]:
            visited[nd][nx][ny] = nk
            q.append((nx, ny, dist, nd))

    N, M, K = map(int, input().split())
    wall = [list(map(int, input().strip())) for _ in range(N)]
    visited = [[[K + 1] * M for _ in range(N)] for _ in range(2)]
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    q = deque([(0, 0, 1, 1)])
    visited[1][0][0] = 0

    while q:
        x, y, dist, day = q.popleft()
        k = visited[day][x][y]
        if x == N - 1 and y == M - 1:
            print(dist)
            return
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            next_day = 1 - day

            if not (0 <= nx < N and 0 <= ny < M):
                continue

            if not wall[nx][ny] and k < visited[next_day][nx][ny]:
                visited[next_day][nx][ny] = k
                q.append((nx, ny, dist + 1, next_day))

            elif wall[nx][ny]:
                if day and k < K:
                    try_push(nx, ny, k + 1, dist + 1, next_day)
                if not day:
                    try_push(x, y, k, dist + 1, next_day)

    print(-1)


if __name__ == "__main__":
    solution()
