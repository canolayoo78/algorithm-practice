import sys
from collections import deque

input = sys.stdin.readline


def solution():
    N = int(input())
    q = deque([])
    for _ in range(N):
        command = input().strip()
        if command == "pop":
            print(-1 if not q else q.popleft())
        elif command == "size":
            print(len(q))
        elif command == "empty":
            print(1 if not q else 0)
        elif command == "front":
            print(-1 if not q else q[0])
        elif command == "back":
            print(-1 if not q else q[-1])
        else:
            _, n = command.split()
            q.append(int(n))


if __name__ == "__main__":
    solution()
