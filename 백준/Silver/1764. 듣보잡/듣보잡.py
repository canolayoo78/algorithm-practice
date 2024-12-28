import sys

input = sys.stdin.readline


def solution():
    H, S = map(int, input().split())
    no_hear_list = {}
    no_hear_no_see_list = []

    for _ in range(H):
        no_hear_list[input()] = True

    for _ in range(S):
        name = input()
        if name in no_hear_list:
            no_hear_no_see_list.append(name)

    no_hear_no_see_list.sort()

    print(len(no_hear_no_see_list))
    print("".join(no_hear_no_see_list))


solution()
