import sys

sys.setrecursionlimit(10**4)
input = sys.stdin.readline
# print = sys.stdout.write

T = int(input())
steps = [(1, 0), (-1, 0), (0, -1), (0, 1)]
board = []
visited = []


def dfs(x, y):
    visited[x][y] = True

    for tx, ty in steps:
        nx, ny = x + tx, y + ty
        if nx in range(M) and ny in range(N) and not visited[nx][ny] and board[nx][ny]:
            dfs(nx, ny)

    # 차세대 영농인 한나
    # 차세대 영농인 두울


for _ in range(T):
    M, N, K = map(int, input().split())
    board = [[False for _ in range(N)] for _ in range(M)]
    visited = [[False for _ in range(N)] for _ in range(M)]
    for _ in range(K):
        cabbage_x, cabbage_y = map(int, input().split())
        board[cabbage_x][cabbage_y] = True

    ans = 0

    for x in range(M):
        for y in range(N):
            if board[x][y] and not visited[x][y]:
                dfs(x, y)
                ans += 1

    print(ans)
