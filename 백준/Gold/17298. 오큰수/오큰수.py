import sys
from collections import deque

input = sys.stdin.readline


def solution():
    N = int(input())

    numbers = list(map(int, input().split()))
    queue = deque()
    answer = [0] * N

    for i in range(N):

        while queue and numbers[queue[-1]] < numbers[i]:
            index = queue.pop()
            answer[index] = numbers[i]

        queue.append(i)

    while queue:
        index = queue.pop()
        answer[index] = -1

    print(" ".join(str(a) for a in answer))


if __name__ == "__main__":
    solution()
