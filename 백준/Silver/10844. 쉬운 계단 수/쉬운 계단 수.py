import sys

input = sys.stdin.readline
write = sys.stdout.write
MOD = 1000000000


def solution():
    N = int(input())
    dp = [[0] * 10 for _ in range(N + 1)]

    for end in range(1, 10):
        dp[1][end] = 1

    for length in range(2, N + 1):
        dp[length][0] = dp[length - 1][1] % MOD
        for end in range(1, 9):
            dp[length][end] = (dp[length - 1][end - 1] + dp[length - 1][end + 1]) % MOD
        dp[length][9] = dp[length - 1][8] % MOD

    print(sum(dp[N]) % MOD)


if __name__ == "__main__":
    solution()
