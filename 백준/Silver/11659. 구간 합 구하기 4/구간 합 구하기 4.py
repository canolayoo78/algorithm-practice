import sys

input = sys.stdin.readline


def solution(N, M):
    numbers = list(map(int, input().split()))
    sum = [0] * (N + 1)

    for i in range(1, N + 1):
        sum[i] = sum[i - 1] + numbers[i - 1]

    for _ in range(M):
        start, end = map(int, input().split())
        print(sum[end] - sum[start - 1])


if __name__ == "__main__":
    N, M = map(int, input().split())
    solution(N, M)
