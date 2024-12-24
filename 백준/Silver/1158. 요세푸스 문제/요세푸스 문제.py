import sys
from collections import deque

input = sys.stdin.readline


def find_josephus_permutation(N, K):
    queue = deque(range(1, N + 1))
    josephus_permutation = []

    while len(queue) > 0:
        for _ in range(K - 1):
            queue.append(queue.popleft())
        josephus_permutation.append(queue.popleft())

    return str(josephus_permutation).replace("[", "<").replace("]", ">")


N, K = map(int, input().split())
print(find_josephus_permutation(N, K))
