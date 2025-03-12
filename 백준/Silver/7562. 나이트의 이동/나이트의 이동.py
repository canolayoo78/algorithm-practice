import sys
from collections import deque

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    now_x, now_y = map(int, sys.stdin.readline().split())
    dest_x, dest_y = map(int, sys.stdin.readline().split())

    graph = [[0] * N for _ in range(N)]
    visited = [[False] * N for _ in range(N)]

    q = deque()

    # 시계방향
    dx = [-2, -1, 1, 2, 2, 1, -1, -2]
    dy = [1, 2, 2, 1, -1, -2, -2, -1]

    def bfs():
        q.append((now_x, now_y))
        visited[now_x][now_y] = 1

        while q:
            x, y = q.popleft()

            if x == dest_x and y == dest_y:
                return 0

            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or N <= nx or ny < 0 or N <= ny:
                    continue

                if nx == dest_x and ny == dest_y:
                    visited[nx][ny] = True
                    return graph[x][y] + 1

                if visited[nx][ny] is False:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    graph[nx][ny] = graph[x][y] + 1

    print(bfs())
