import sys
from collections import deque

input = sys.stdin.readline

M, N, H = map(int, input().split())
graph = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]
visited = [[[0] * M for _ in range(N)] for _ in range(H)]

dx = [0, 1, 0, -1, 0, 0]
dy = [1, 0, -1, 0, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

q = deque()


def bfs():
    while q:
        z, x, y = q.popleft()

        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]

            if nx < 0 or N <= nx or ny < 0 or M <= ny or nz < 0 or H <= nz:
                continue

            if graph[nz][nx][ny] == 0 and visited[nz][nx][ny] == 0:
                graph[nz][nx][ny] = graph[z][x][y] + 1
                visited[nz][nx][ny] = 1
                q.append((nz, nx, ny))


if __name__ == "__main__":
    for i in range(H):
        for j in range(N):
            for k in range(M):
                if graph[i][j][k] == 1 and visited[i][j][k] == 0:
                    q.append((i, j, k))
                    visited[i][j][k] = 1
    bfs()
    answer = 0
    for floor in graph:
        for x in floor:
            for y in x:
                if y == 0:
                    print(-1)
                    exit(0)
            answer = max(answer, max(x))
    print(answer - 1)
