import sys

input = sys.stdin.readline


def solution():
    N, M = map(int, input().split())

    numbers = [0] + list(map(int, input().split()))
    counts = [0] * (M)

    for i in range(1, N + 1):
        numbers[i] += numbers[i - 1]
        numbers[i] = numbers[i] % M
        counts[numbers[i]] += 1

    ans = counts[0]
    for i in range(M):
        if counts[i] > 1:
            ans += counts[i] * (counts[i] - 1) // 2

    print(ans)


if __name__ == "__main__":
    solution()
