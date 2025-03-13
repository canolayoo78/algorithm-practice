import sys

input = sys.stdin.readline


def solution():
    T = int(input())
    for _ in range(T):
        k = int(input())
        n = int(input())
        dp = [i for i in range(1, n + 1)]

        for _ in range(1, k + 1):
            for j in range(1, n):
                dp[j] += dp[j - 1]

        print(dp[-1])


if __name__ == "__main__":
    solution()
