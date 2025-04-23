import sys

sys.setrecursionlimit(10000)

input = sys.stdin.readline
print = sys.stdout.write


def solution():
    M, N = map(int, input().split())
    numbers = [True] * (N + 1)
    numbers[1] = False

    for i in range(2, int(N ** 0.5) + 1):
        if numbers[i]:
            for j in range(2 * i, N + 1, i):
                numbers[j] = False

    for i in range(M, N + 1):
        if numbers[i]:
            print(str(i) + "\n")


if __name__ == "__main__":
    solution()
