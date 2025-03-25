import sys

input = sys.stdin.readline


def solution():
    N = int(input())

    times = list(map(int, input().split()))
    times.sort()
    time_sum = 0
    for i in range(1, N + 1):
        time_sum += sum(times[:i])

    print(time_sum)


solution()
