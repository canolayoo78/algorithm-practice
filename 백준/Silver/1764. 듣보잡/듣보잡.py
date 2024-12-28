import sys

input = sys.stdin.readline


def solution():
    H, S = map(int, input().split())
    no_hear_no_see_list = []

    for _ in range(H + S):
        no_hear_no_see_list.append(input())

    no_hear_no_see_list.sort()
    result = [a for a, b in zip(no_hear_no_see_list, no_hear_no_see_list[1:]) if a == b]

    print(len(result))
    print("".join(result))


solution()
