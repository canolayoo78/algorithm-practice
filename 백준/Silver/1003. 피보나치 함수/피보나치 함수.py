import sys

input = sys.stdin.readline


def solution():
    T = int(input())
    cases = [int(input()) for _ in range(T)]

    max_case = max(cases)
    result = [1, 0]

    for i in range(2, max_case + 2):
        result.append(result[i - 1] + result[i - 2])

    for case in cases:
        print(f"{result[case]} {result[case+1]}")


solution()
