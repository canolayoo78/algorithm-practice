import sys

input = sys.stdin.readline
MAX = 10001


def solution():
    N, K = map(int, input().split())
    numbers = list(map(int, input().split()))
    numbers.sort()

    print(numbers[K - 1])


if __name__ == "__main__":
    solution()
