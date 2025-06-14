import sys

input = sys.stdin.readline


def solution():
    M = int(input())

    if M <= 30:
        print(f"{M/2:.1f}")
    else:
        print(f"{15+(M-30)/2*3:.1f}")


if __name__ == "__main__":
    solution()
