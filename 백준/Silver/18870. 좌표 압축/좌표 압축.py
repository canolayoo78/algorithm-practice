import sys

input = sys.stdin.readline


def solution():
    _ = int(input())
    numbers = list(map(int, input().split()))

    sorted_unique_numbers = sorted(set(numbers))

    compressed_mapping = {
        number: index for index, number in enumerate(sorted_unique_numbers)
    }

    compressed_numbers = [compressed_mapping[number] for number in numbers]

    print(" ".join(map(str, compressed_numbers)))


if __name__ == "__main__":
    solution()
