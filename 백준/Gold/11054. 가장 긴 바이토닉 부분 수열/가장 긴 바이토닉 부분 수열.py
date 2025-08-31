import bisect
import sys
input = sys.stdin.readline


def solution():
    N = int(input())
    num = list(map(int, input().split()))
    increase_tails = []
    decrease_tails = []
    L = [1] * (N + 1)
    R = [1] * (N + 1)

    for i in range(N):
        pos = bisect.bisect_left(increase_tails, num[i])
        if pos == len(increase_tails):
            increase_tails.append(num[i])
        else:
            increase_tails[pos] = num[i]
        L[i] = len(increase_tails)

    for i in range(N - 1, -1, -1):
        pos = bisect.bisect_left(decrease_tails, num[i])
        if pos == len(decrease_tails):
            decrease_tails.append(num[i])
        else:
            decrease_tails[pos] = num[i]
        R[i] = len(decrease_tails)

    ans = 0
    for i in range(N):
        ans = max(ans, L[i] + R[i] - 1)
    print(ans)


if __name__ == "__main__":
    solution()
