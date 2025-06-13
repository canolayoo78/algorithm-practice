import sys

input = sys.stdin.readline


def solution():
    _ = int(input())
    defenses = list(map(int, input().split()))
    V = 0.0
    for d in defenses:
        V = 1 - (1 - V) * (1 - (d / 100))
        print(f"{V * 100:.6f}")


if __name__ == "__main__":
    solution()
