import sys

input = sys.stdin.readline


def solution(N):
    dp = [1, 2, 4]
    for i in range(3, N):
        dp.append(sum(dp[i - 3 : i]))
    print(dp[N - 1])


if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        solution(int(input()))
