import sys

input = sys.stdin.readline
MOD = 1000000007


def solution():
    N, L, R = map(int, input().split())
    dp = [[[0] * (N + 1) for _ in range(N + 1)] for _ in range(N + 1)]
    dp[1][1][1] = 1

    for n in range(2, N + 1):
        for l in range(1, L + 1):
            for r in range(1, R + 1):
                dp[n][l][r] = (
                    dp[n - 1][l - 1][r]
                    + dp[n - 1][l][r - 1]
                    + dp[n - 1][l][r] * (n - 2)
                )
    print(dp[N][L][R] % MOD)


if __name__ == "__main__":
    solution()
