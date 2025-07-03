import sys

input = sys.stdin.readline


def solution():
    N = int(input())

    if N == 1 or N == 3:
        print(-1)

    else:
        ans = N // 5
        N %= 5
        if N % 2 != 0:
            ans -= 1
            N += 5
        print(ans + N // 2)


if __name__ == "__main__":
    solution()
