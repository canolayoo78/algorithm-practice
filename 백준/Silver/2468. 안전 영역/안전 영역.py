import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
visited = [[0] * N for _ in range(N)]
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def bfs(high, x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = 1

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or N <= nx or ny < 0 or N <= ny:
                continue

            if graph[nx][ny] > high and visited[nx][ny] == 0:
                q.append((nx, ny))
                visited[nx][ny] = 1


if __name__ == "__main__":
    safe_areas = [0] * 101
    for high in range(101):
        safe_area = 0
        visited = [[0] * N for _ in range(N)]
        for i in range(N):
            for j in range(N):
                if graph[i][j] > high and visited[i][j] == 0:
                    bfs(high, i, j)
                    safe_area += 1
        safe_areas[high] = safe_area

    print(max(safe_areas))
