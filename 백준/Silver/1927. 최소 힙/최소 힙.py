import heapq
import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    heap = []
    outputs = []
    for _ in range(N):
        x = int(input())
        if x == 0:
            outputs.append(heapq.heappop(heap) if heap else "0")

        else:
            heapq.heappush(heap, x)

    print("\n".join(str(output) for output in outputs))


if __name__ == "__main__":
    solution()
