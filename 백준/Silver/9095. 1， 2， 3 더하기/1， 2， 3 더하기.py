import sys

input = sys.stdin.readline

dp = [1, 2, 4]


def solution(N):
    for i in range(len(dp), N):
        dp.append(sum(dp[i - 3 : i]))
    print(dp[N - 1])


if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        solution(int(input()))
