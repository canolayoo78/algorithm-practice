
import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    num = list(map(int, input().split()))
    dp_increase = [1] * N
    dp_decrease = [1] * N

    for i in range(1, N):
        for j in range(i):
            if num[i] > num[j]:
                dp_increase[i] = max(dp_increase[i], dp_increase[j] + 1)

    for i in range(N - 2, -1, -1):
        for j in range(N - 1, i, -1):
            if num[i] > num[j]:
                dp_decrease[i] = max(dp_decrease[i], dp_decrease[j] + 1)

    ans = 0
    for x, y in zip(dp_increase, dp_decrease):
        ans = max(ans, x + y - 1)

    print(ans)


if __name__ == "__main__":
    solution()
