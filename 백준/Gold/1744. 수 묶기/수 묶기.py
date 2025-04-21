import heapq
import sys

sys.setrecursionlimit(10000)

input = sys.stdin.readline
# print = sys.stdout.write


def solution():
    N = int(input())
    nums = [int(input()) for _ in range(N)]
    negative_heap = []
    positive_heap = []

    ans = 0

    for num in nums:
        if num > 1:
            heapq.heappush(positive_heap, -num)
        elif num <= 0:
            heapq.heappush(negative_heap, num)
        else:
            ans += 1

    while positive_heap:
        if len(positive_heap) == 1:
            ans += -heapq.heappop(positive_heap)

        else:
            max1 = -heapq.heappop(positive_heap)
            max2 = -heapq.heappop(positive_heap)

            multiple = max1 * max2
            ans += multiple

    while negative_heap:
        if len(negative_heap) == 1:
            ans += heapq.heappop(negative_heap)

        else:
            max1 = heapq.heappop(negative_heap)
            max2 = heapq.heappop(negative_heap)

            multiple = max1 * max2
            ans += multiple

    print(ans)


if __name__ == "__main__":
    solution()
