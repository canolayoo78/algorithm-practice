import sys
from collections import deque

input = sys.stdin.readline
print = sys.stdout.write


def solution():
    N = int(input())
    target = [int(input()) for _ in range(N)]
    queue = deque()
    index = 0
    ans = []

    for i in range(1, N + 1):
        queue.append(i)
        ans.append("+")

        while queue and target[index] == queue[-1]:
            queue.pop()
            ans.append("-")
            index += 1

    if queue:
        print("NO")
    else:
        print("\n".join(ans))


if __name__ == "__main__":
    solution()
