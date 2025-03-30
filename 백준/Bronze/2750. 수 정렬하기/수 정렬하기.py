import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    numbers = []
    for _ in range(N):
        numbers.append(int(input()))
    print("\n".join(map(str, sorted(numbers))))


if __name__ == "__main__":
    solution()
