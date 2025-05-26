import sys

input = sys.stdin.readline
print = sys.stdout.write
INF = sys.maxsize


def solution():
    n = int(input())
    m = int(input())
    distances = [[INF for _ in range(n + 1)] for _ in range(n + 1)]
    for i in range(1, n + 1):
        distances[i][i] = 0
    for _ in range(m):
        a, b, c = map(int, input().split())
        distances[a][b] = min(distances[a][b], c)

    for k in range(1, n + 1):
        for s in range(1, n + 1):
            for e in range(1, n + 1):
                distances[s][e] = min(
                    distances[s][e], distances[s][k] + distances[k][e]
                )

    for i in range(1, n + 1):
        for j in range(1, n + 1):
            print("0" if distances[i][j] == INF else str(distances[i][j]))
            print(" ")
        print("\n")


if __name__ == "__main__":
    solution()
