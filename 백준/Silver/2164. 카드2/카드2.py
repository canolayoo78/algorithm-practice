import math
import sys

input = sys.stdin.readline


def find_last_card(N):
    josephus = 2 ** math.floor(math.log2(N))
    last_card = 2 * (N - josephus)
    return last_card if last_card != 0 else N


N = int(input())
print(find_last_card(N))
