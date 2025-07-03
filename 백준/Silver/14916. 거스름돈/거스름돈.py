import sys

input = sys.stdin.readline

MAX = sys.maxsize
sys.setrecursionlimit(100000)


def solution():
    N = int(input())
    dp = [MAX] * (N + 1 if N > 5 else 6)
    dp[2], dp[5] = 1, 1

    def solve(n):
        if dp[n] != MAX:
            return dp[n]
        if n > 2:
            dp[n] = min(solve(n - 2) + 1, dp[n])
        if n > 5:
            dp[n] = min(solve(n - 5) + 1, dp[n])
        return dp[n]

    solve(N)
    print(dp[N] if dp[N] != MAX else -1)


if __name__ == "__main__":
    solution()
