import sys

input = sys.stdin.readline


def solution():
    N, K = map(int, input().split())
    stuff = [list(map(int, input().split())) for _ in range(N)]
    dp = [[0] * (K + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        for j in range(1, K + 1):
            if j >= stuff[i - 1][0]:
                dp[i][j] = max(
                    stuff[i - 1][1] + dp[i - 1][j - stuff[i - 1][0]], dp[i - 1][j]
                )
            else:
                dp[i][j] = dp[i - 1][j]
    print(dp[-1][-1])


if __name__ == "__main__":
    solution()
