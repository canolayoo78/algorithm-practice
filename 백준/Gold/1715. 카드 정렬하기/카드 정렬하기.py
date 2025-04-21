import heapq
import sys


input = sys.stdin.readline


def solution():
    N = int(input())
    decks = [int(input()) for _ in range(N)]
    heapq.heapify(decks)
    ans = 0
    while len(decks) > 1:
        min1 = heapq.heappop(decks)
        min2 = heapq.heappop(decks)
        sub_sum = min1 + min2
        ans += sub_sum
        heapq.heappush(decks, sub_sum)

    print(ans)


if __name__ == "__main__":
    solution()
