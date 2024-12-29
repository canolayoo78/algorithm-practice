import sys

input = sys.stdin.readline


def solution():
    T = int(input())

    cases = [int(input()) for _ in range(T)]
    max_case = max(cases)
    zeros = [1, 0]
    ones = [0, 1]
    for i in range(2, max_case + 1):
        zeros.append(zeros[i - 1] + zeros[i - 2])
        ones.append(ones[i - 1] + ones[i - 2])

    for case in cases:
        print(f"{zeros[case]} {ones[case]}")


solution()
