import sys

sys.setrecursionlimit(10000)

input = sys.stdin.readline
# print = sys.stdout.write


def solution():
    N, M = map(int, input().split())

    def euclidean(larger, smaller):
        mod = larger % smaller
        if mod == 0:
            return smaller

        else:
            return euclidean(smaller, mod)

    gcd = euclidean(N, M)
    lcm = (N * M) // gcd
    print(lcm)


if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        solution()
