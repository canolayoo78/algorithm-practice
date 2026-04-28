import sys

input = sys.stdin.readline


def solution():
    high = int(input())
    medium = int(input())
    low = int(input())
    coke = int(input())
    sprite = int(input())

    print(min(high, medium, low) + min(coke, sprite) - 50)


if __name__ == "__main__":
    solution()
