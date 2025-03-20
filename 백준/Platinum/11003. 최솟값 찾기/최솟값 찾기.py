import sys
from collections import deque

input = sys.stdin.readline

MAX = 10**9


def solution():
    N, L = map(int, input().split())

    numbers = [0] + list(map(int, input().split()))
    queue = deque()
    queue.append((0, MAX))
    for i in range(1, N + 1):
        while queue and i - queue[0][0] >= L:
            queue.popleft()
        while queue and queue[-1][1] > numbers[i]:
            queue.pop()

        queue.append((i, numbers[i]))
        print(queue[0][1], end=" ")


if __name__ == "__main__":
    solution()
