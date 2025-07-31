import sys
from collections import deque

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    def bfs(i, j, group_id):
        q = deque([(i, j)])
        visited[i][j] = group_id
        group_len = 0
        while q:
            x, y = q.popleft()
            group_len += 1
            for d in range(4):
                nx, ny = x + dx[d], y + dy[d]
                if (
                    0 <= nx < N
                    and 0 <= ny < M
                    and not wall[nx][ny]
                    and not visited[nx][ny]
                ):
                    q.append((nx, ny))
                    visited[nx][ny] = group_id
        group_dict.append(group_len)

    N, M = map(int, input().split())
    wall = [list(map(int, input().strip())) for _ in range(N)]
    visited = [[0] * M for _ in range(N)]
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    group_dict = [0]

    group_id = 1
    for i in range(N):
        for j in range(M):
            if not wall[i][j] and not visited[i][j]:
                bfs(i, j, group_id)
                group_id += 1

    for x in range(N):
        for y in range(M):
            if wall[x][y]:
                adj_groups = set()
                for d in range(4):
                    nx, ny = x + dx[d], y + dy[d]
                    if 0 <= nx < N and 0 <= ny < M:
                        adj_groups.add(visited[nx][ny])
                for g in adj_groups:
                    wall[x][y] += group_dict[g]

    out_lines = ["".join(str(c % 10) for c in row) for row in wall]
    write("\n".join(out_lines))


if __name__ == "__main__":
    solution()
