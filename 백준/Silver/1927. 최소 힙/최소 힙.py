import heapq
import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    heap = []
    for _ in range(N):
        x = int(input())
        if x == 0 and heap:
            removed = heapq.heappop(heap)
            print(removed)
        elif x == 0 and not heap:
            print("0")
        else:
            heapq.heappush(heap, x)


if __name__ == "__main__":
    solution()
