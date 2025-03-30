import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    numbers = []
    for index in range(1, N + 1):
        numbers.append((int(input()), index))
    sorted_numbers = sorted(numbers)

    max = 0
    for index in range(N):
        if max < sorted_numbers[index][1] - index:
            max = sorted_numbers[index][1] - index
    print(max)


if __name__ == "__main__":
    solution()
