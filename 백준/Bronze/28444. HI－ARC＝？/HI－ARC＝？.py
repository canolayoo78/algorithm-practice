import sys

input = sys.stdin.readline


def solution():
    H, I, A, R, C = map(int, input().split())

    print(H * I - A * R * C)


if __name__ == "__main__":
    solution()
