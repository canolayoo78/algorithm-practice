import sys
from collections import deque

input = sys.stdin.readline


def solution():
    def init():
        for i in range(N):
            for j in range(M):
                if whole_map[i][j] != 0:
                    iceberg_queue.append((i, j))
                    sea_count = 0
                    for d in range(4):
                        nx, ny = i + dx[d], j + dy[d]
                        if 0 <= nx < N and 0 <= ny < M and whole_map[nx][ny] == 0:
                            sea_count += 1
                    sea_map[i][j] = sea_count

    def melt():
        iceberg_num = len(iceberg_queue)
        new_sea_queue = deque([])

        for _ in range(iceberg_num):
            i, j = iceberg_queue.popleft()
            if whole_map[i][j] - sea_map[i][j] > 0:
                whole_map[i][j] = whole_map[i][j] - sea_map[i][j]
                iceberg_queue.append((i, j))
            else:
                whole_map[i][j], sea_map[i][j] = 0, 0
                new_sea_queue.append((i, j))

        while new_sea_queue:
            i, j = new_sea_queue.popleft()
            for d in range(4):
                nx, ny = i + dx[d], j + dy[d]
                if 0 <= nx < N and 0 <= ny < M and whole_map[nx][ny] != 0:
                    sea_map[nx][ny] += 1

    def bfs(start_x, start_y):
        visited[start_x][start_y] = year
        q = deque([(start_x, start_y)])

        while q:
            cur_x, cur_y = q.popleft()
            for d in range(4):
                next_x, next_y = cur_x + dx[d], cur_y + dy[d]
                if (
                    0 <= next_x < N
                    and 0 <= next_y < M
                    and visited[next_x][next_y] != year
                    and whole_map[next_x][next_y] != 0
                ):
                    visited[next_x][next_y] = year
                    q.append((next_x, next_y))

    def is_separated():
        start_x, start_y = iceberg_queue[0]
        bfs(start_x, start_y)
        for i, j in iceberg_queue:
            if visited[i][j] != year:
                return True
        return False

    N, M = map(int, input().split())
    whole_map = [list(map(int, input().split())) for _ in range(N)]
    iceberg_queue = deque([])
    sea_map = [[0] * M for _ in range(N)]
    visited = [[-1] * M for _ in range(N)]

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    init()
    year = 0
    while True:
        if not iceberg_queue:
            print(0)
            return
        if is_separated():
            print(year)
            return
        year += 1
        melt()


if __name__ == "__main__":
    solution()
