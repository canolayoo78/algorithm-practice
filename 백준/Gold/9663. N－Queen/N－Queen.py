import sys
from collections import defaultdict

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def solution():
    N = int(input())
    used_col = [False] * N
    used_diag1 = defaultdict(bool)
    used_diag2 = defaultdict(bool)
    ans = 0

    def dfs(row):
        nonlocal ans
        if row == N:
            ans += 1
            return
        for col in range(0, N):
            if (
                not used_col[col]
                and not used_diag1[col + row]
                and not used_diag2[col - row]
            ):
                used_col[col] = True
                used_diag1[col + row] = True
                used_diag2[col - row] = True
                dfs(row + 1)
                used_col[col] = False
                used_diag1[col + row] = False
                used_diag2[col - row] = False

    dfs(0)
    print(ans)


if __name__ == "__main__":
    solution()
