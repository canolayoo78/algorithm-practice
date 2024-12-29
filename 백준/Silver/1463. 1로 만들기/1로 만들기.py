import sys

input = sys.stdin.readline

dict = {1: 0, 2: 1, 3: 1}


def solution(N):
    if N not in dict:
        dict[N] = 1 + min(solution(N // 3) + N % 3, solution(N // 2) + N % 2)
    return dict[N]


print(solution(int(input())))
