import sys

input = sys.stdin.readline


def solution():
    _, M, K = map(int, input().split())
    print(K // M, K % M)


if __name__ == "__main__":
    solution()
