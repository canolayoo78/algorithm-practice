import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
map = [input().split() for _ in range(N)]
visited = [[False] * M for _ in range(N)]
ans = [[0] * M for _ in range(N)]
steps = [(1, 0), (-1, 0), (0, -1), (0, 1)]
seek = deque()

for i in range(N):
    for j in range(M):
        if map[i][j] == "2":
            visited[i][j] = True
            seek.append((i, j))


def solution():
    while seek:
        x, y = seek.popleft()

        for tx, ty in steps:
            nx, ny = x + tx, y + ty

            if (
                nx in range(N)
                and ny in range(M)
                and not visited[nx][ny]
                and map[nx][ny] == "1"
            ):
                seek.append((nx, ny))
                visited[nx][ny] = True
                ans[nx][ny] = ans[x][y] + 1

    for i in range(N):
        for j in range(M):
            if not visited[i][j] and map[i][j] == "1":
                print(-1, end=" ")
            else:
                print(ans[i][j], end=" ")
        print()


if __name__ == "__main__":
    solution()
