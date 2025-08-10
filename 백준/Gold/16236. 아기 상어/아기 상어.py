import sys
from collections import deque

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    N = int(input())
    space = [list(map(int, input().split())) for _ in range(N)]
    start_x, start_y = 0, 0
    move = [(-1, 0), (0, -1), (0, 1), (1, 0)]
    for i in range(N):
        for j in range(N):
            if space[i][j] == 0:
                continue
            if space[i][j] == 9:
                start_x, start_y = i, j
                space[i][j] = 0

    def bfs(start_x, start_y):
        q = deque([(start_x, start_y)])
        distances = [[-1] * N for _ in range(N)]
        distances[start_x][start_y] = 0
        candidates = []

        while q:
            level_size = len(q)
            for _ in range(level_size):
                x, y = q.popleft()
                for dx, dy in move:
                    nx, ny = x + dx, y + dy
                    if not (0 <= nx < N and 0 <= ny < N):
                        continue
                    if distances[nx][ny] != -1:
                        continue
                    if space[nx][ny] <= baby_shark:
                        distances[nx][ny] = distances[x][y] + 1
                        if 0 < space[nx][ny] < baby_shark:
                            candidates.append((nx, ny))
                        else:
                            q.append((nx, ny))
            if candidates:
                px, py = min(candidates)
                return px, py, distances[px][py]
        return None, None, None

    baby_shark = 2
    eat_count = 0
    time = 0

    while True:
        start_x, start_y, dist = bfs(start_x, start_y)
        if dist is None:
            break
        time += dist
        eat_count += 1
        space[start_x][start_y] = 0
        if eat_count == baby_shark:
            eat_count = 0
            baby_shark += 1

    print(time)


if __name__ == "__main__":
    solution()
