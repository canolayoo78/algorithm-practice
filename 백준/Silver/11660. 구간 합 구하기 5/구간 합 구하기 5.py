import sys

input = sys.stdin.readline


def solution():
    N, M = map(int, input().split())

    table = [[0] + list(map(int, input().split())) for _ in range(N)]
    table = [[0] * (N + 1)] + table

    for i in range(1, N + 1):
        for j in range(1, N + 1):
            table[i][j] = table[i][j - 1] + table[i - 1][j] - table[i - 1][j - 1] + table[i][j]
            

    for _ in range(M):
        sx, sy, ex, ey = map(int, input().split())
        print(table[ex][ey] - table[sx - 1][ey] - table[ex][sy - 1] + table[sx - 1][sy - 1])


if __name__ == "__main__":
    solution()
