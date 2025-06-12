import sys

input = sys.stdin.readline


def solution():
    rail = int(input())
    flight = int(input())

    if rail > flight:
        print("flight")
    else:
        print("high speed rail")


if __name__ == "__main__":
    solution()
