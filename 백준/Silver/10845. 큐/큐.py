import sys
from collections import deque

input = sys.stdin.readline
write = sys.stdout.write

def solution():
    N = int(input())
    q = deque([])
    result = []
    for _ in range(N):
        command = input().strip()
        if command == "pop":
            result.append(-1 if not q else q.popleft())
        elif command == "size":
            result.append(len(q))
        elif command == "empty":
            result.append(1 if not q else 0)
        elif command == "front":
            result.append(-1 if not q else q[0])
        elif command == "back":
            result.append(-1 if not q else q[-1])
        else:
            _, n = command.split()
            q.append(int(n))
    write("\n".join(map(str, result)))


if __name__ == "__main__":
    solution()
