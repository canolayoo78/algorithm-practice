import sys
from collections import deque

input = sys.stdin.readline


def solution():
    def bfs(start_x, start_y):
        q = deque([(start_x, start_y, 0, 1)])
        visited[start_x][start_y][0] = 1

        while q:
            cur_x, cur_y, broken_cnt, dist = q.popleft()
            if cur_x == N - 1 and cur_y == M - 1:
                print(dist)
                return
            for d in range(4):
                next_x, next_y = cur_x + dx[d], cur_y + dy[d]
                if 0 <= next_x < N and 0 <= next_y < M:
                    if (
                        map_list[next_x][next_y] == 0
                        and not visited[next_x][next_y][broken_cnt]
                    ):
                        visited[next_x][next_y][broken_cnt] = 1
                        q.append((next_x, next_y, broken_cnt, dist + 1))
                    elif broken_cnt < K and not visited[next_x][next_y][broken_cnt + 1]:
                        visited[next_x][next_y][broken_cnt + 1] = 1
                        q.append((next_x, next_y, broken_cnt + 1, dist + 1))

        print(-1)

    N, M, K = map(int, input().split())
    map_list = [list(map(int, input().strip())) for _ in range(N)]
    visited = [[[0] * (K + 1) for _ in range(M)] for _ in range(N)]
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    bfs(0, 0)


if __name__ == "__main__":
    solution()
