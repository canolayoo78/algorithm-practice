import sys
from collections import deque

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    N, M = map(int, input().split())
    wall = [list(map(int, input().strip())) for _ in range(N)]
    visited = [[0] * M for _ in range(N)]
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    group_id = 0

    for i in range(N):
        for j in range(M):
            if wall[i][j] or visited[i][j]:
                continue

            q = deque([(i, j)])
            add_to = []
            group_id += 1
            visited[i][j] = group_id
            group_len = 0

            while q:
                x, y = q.popleft()
                group_len += 1
                for d in range(4):
                    nx, ny = x + dx[d], y + dy[d]
                    if not (0 <= nx < N and 0 <= ny < M):
                        continue
                    if visited[nx][ny] == group_id:
                        continue
                    visited[nx][ny] = group_id
                    if wall[nx][ny]:
                        add_to.append((nx, ny))
                    else:
                        q.append((nx, ny))
            for x, y in add_to:
                wall[x][y] += group_len

    out_lines = ["".join(str(c % 10) for c in row) for row in wall]
    write("\n".join(out_lines))


if __name__ == "__main__":
    solution()
