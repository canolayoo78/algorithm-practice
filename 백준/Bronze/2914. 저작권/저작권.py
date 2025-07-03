import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    A, I = map(int, input().split())

    write(str(A * (I - 1) + 1))


if __name__ == "__main__":
    solution()
