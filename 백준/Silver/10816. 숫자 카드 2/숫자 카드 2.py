import sys
from collections import defaultdict

input = sys.stdin.readline
write = sys.stdout.write
read = sys.stdin.buffer.read
sys.setrecursionlimit(10**6)


def solution():
    _ = int(input())
    cards = list(map(int, input().split()))
    _ = int(input())
    queries = list(map(int, input().split()))
    card_dict = defaultdict(int)
    result = []
    for c in cards:
        card_dict[c] += 1
    for q in queries:
        result.append(card_dict[q])
    write(" ".join(map(str, result)))


if __name__ == "__main__":
    solution()
