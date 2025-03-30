import sys

input = sys.stdin.readline
print = sys.stdout.write
MAX = 10001


def solution():
    N = int(input())
    count = [0] * MAX

    for _ in range(N):
        count[int(input())] += 1

    for i in range(MAX):
        for _ in range(count[i]):
            print(str(i) + "\n")


if __name__ == "__main__":
    solution()
