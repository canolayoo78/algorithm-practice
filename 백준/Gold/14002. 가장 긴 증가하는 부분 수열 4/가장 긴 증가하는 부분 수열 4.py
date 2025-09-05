import bisect
import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    num = list(map(int, input().split()))
    tails_val = []
    tails_idx = []
    pos = [0] * N
    parent = [-1] * N

    for i in range(N):
        loc = bisect.bisect_left(tails_val, num[i])
        pos[i] = loc
        if loc > 0:
            parent[i] = tails_idx[loc-1]
        if loc == len(tails_val):
            tails_val.append(num[i])
            tails_idx.append(i)
        else:
            tails_val[loc] = num[i]
            tails_idx[loc] = i
      
    L = len(tails_val)
    ans = []
    k = tails_idx[L - 1]
    while k != -1:
        ans.append(num[k])
        k = parent[k]
    ans.reverse()
    print(len(tails_val))
    print(*ans)


if __name__ == "__main__":
    solution()
