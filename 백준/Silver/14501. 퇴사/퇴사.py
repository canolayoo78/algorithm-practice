import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    dp = [0] * (N + 2)
    T = [0] * (N + 1)
    P = [0] * (N + 1)

    for i in range(1, N + 1):
        T[i], P[i] = map(int, input().split())

    for i in range(N, 0, -1):
        if i + T[i] > N + 1:
            dp[i] = dp[i + 1]
        else:
            dp[i] = max(dp[i + T[i]] + P[i], dp[i + 1])

    print(dp[1])


if __name__ == "__main__":
    solution()
