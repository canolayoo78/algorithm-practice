import sys

input = sys.stdin.readline


def solution():
    numbers = list(map(int, input().strip()))
    numbers.sort(reverse=True)
    print("".join(map(str, numbers)))


if __name__ == "__main__":
    solution()
