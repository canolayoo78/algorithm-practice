import heapq
import sys
from collections import defaultdict

input = sys.stdin.readline
write = sys.stdout.write
read = sys.stdin.buffer.read
sys.setrecursionlimit(10**6)


def solution():
    k = int(input())
    min_q = []
    max_q = []
    heapq.heapify(min_q)
    heapq.heapify(max_q)
    counts = defaultdict(int)

    def insert(n):
        heapq.heappush(min_q, n)
        heapq.heappush(max_q, -n)
        counts[n] += 1

    def min_pop(q=min_q):
        while q:
            top = heapq.heappop(q)
            if counts[top]:
                return top
        return None

    def max_pop(q=max_q):
        while q:
            top = heapq.heappop(q)
            if counts[-top]:
                return -top
        return None

    for _ in range(k):
        command, n = input().split()
        n = int(n)
        if command == "I":
            insert(n)
        else:
            if n == -1:
                top = min_pop()
            else:
                top = max_pop()
            if top is not None:
                counts[top] -= 1

    min = min_pop()
    max = max_pop()
    if min is None:
        print("EMPTY")
    else:
        print(max, min)


if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        solution()
