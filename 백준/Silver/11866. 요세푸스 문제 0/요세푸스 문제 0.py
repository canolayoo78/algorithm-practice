import sys
from collections import deque

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    N, K = map(int, input().split())
    q = deque([i for i in range(1, N + 1)])
    result = []
    while q:
        for _ in range(K - 1):
            q.append(q.popleft())
        result.append(q.popleft())
    write("<")
    write(", ".join(str(r) for r in result))
    write(">")


if __name__ == "__main__":
    solution()
