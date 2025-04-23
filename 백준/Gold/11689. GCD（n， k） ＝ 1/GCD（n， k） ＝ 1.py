import sys

sys.setrecursionlimit(10000)

input = sys.stdin.readline
# print = sys.stdout.write


def solution():
    N = int(input())
    ans = N

    for i in range(2, int(N**0.5) + 1):
        if N % i == 0:
            while N % i == 0:
                N //= i
            ans *= 1 - 1 / i

    if N > 1:
        ans *= 1 - 1 / N

    print(int(ans))


if __name__ == "__main__":
    solution()
