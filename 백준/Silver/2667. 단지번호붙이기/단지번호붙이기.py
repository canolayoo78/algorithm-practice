import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
graph = []
for i in range(N):
    graph.append(list(map(int, input().strip())))

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]
visited = [[0] * N for _ in range(N)]


def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = 1
    home = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or N <= nx or ny < 0 or N <= ny:
                continue

            if graph[nx][ny] == 0:
                continue

            if graph[nx][ny] == 1 and visited[nx][ny] == 0:
                visited[nx][ny] = 1
                home += 1
                q.append((nx, ny))

    return home


if __name__ == "__main__":
    ans = []
    for i in range(N):
        for j in range(N):
            if graph[i][j] == 1 and visited[i][j] == 0:
                ans.append(bfs(i, j))
    ans.sort()
    print(len(ans))
    print("\n".join(str(e) for e in ans))
