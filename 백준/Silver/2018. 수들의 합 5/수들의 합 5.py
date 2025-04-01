import sys
from collections import deque

input = sys.stdin.readline
# print = sys.stdout.write


def solution():
    N = int(input())
    ans = 0

    for one in range(1, N - 1):
        two = one + 1
        list_sum = one + two
        while two <= N:
            if list_sum == N:
                ans += 1
                break
            elif list_sum < N:
                list_sum += two + 1
                two += 1
            else:
                break

    return ans + 1


if __name__ == "__main__":
    print(solution())
