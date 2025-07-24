import heapq
import sys

input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    N = int(input())
    max_heap = []

    for _ in range(N):
        calc = int(input())

        if calc == 0:
            write("0" if not max_heap else str(-heapq.heappop(max_heap)))
            write("\n")
        else:
            heapq.heappush(max_heap, -calc)


if __name__ == "__main__":
    solution()
