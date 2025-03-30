import sys

input = sys.stdin.readline
print = sys.stdout.write
MAX = 10001


def solution():
    N = int(input())
    count = [0] * MAX

    for _ in range(N):
        count[int(input())] += 1

    for i, a in enumerate(count):
        for _ in range(a):
            print(str(i) + "\n")


if __name__ == "__main__":
    solution()
