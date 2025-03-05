import copy
import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

answer = 0


def bfs():
    tmp_graph = copy.deepcopy(graph)
    q = deque()

    for i in range(N):
        for j in range(M):
            if tmp_graph[i][j] == 2:
                q.append((i, j))

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or N <= nx or ny < 0 or M <= ny:
                continue

            if tmp_graph[nx][ny] == 0:
                tmp_graph[nx][ny] = 2
                q.append((nx, ny))

    cnt_safe = 0
    for i in range(N):
        cnt_safe += tmp_graph[i].count(0)

    return cnt_safe


def make_wall(cnt):
    if cnt == 3:
        global answer
        answer = max(answer, bfs())
        return
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                graph[i][j] = 1
                make_wall(cnt + 1)
                graph[i][j] = 0


if __name__ == "__main__":
    make_wall(0)
    print(answer)
