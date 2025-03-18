import sys

input = sys.stdin.readline


def solution():
    _ = int(input())

    num_list = input().strip()
    num_list = [int(i) for i in num_list]

    print(sum(num_list))


if __name__ == "__main__":
    solution()
