import sys

sys.setrecursionlimit(10000)

input = sys.stdin.readline
# print = sys.stdout.write


def solution():
    N, M = map(int, input().split())

    if N > M:
        larger, smaller = N, M
    else:
        larger, smaller = M, N

    while smaller != 0:
        larger, smaller = smaller, larger % smaller

    lcm = (N * M) // larger
    print(lcm)


if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        solution()
