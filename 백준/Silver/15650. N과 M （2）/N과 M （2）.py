import sys

input = sys.stdin.readline
N, M = map(int, input().split())
s = []


def dfs(start):
    if len(s) == M:
        print(" ".join(str(number) for number in s))
        return

    for i in range(start, N + 1):
        if i not in s:
            s.append(i)
            dfs(i + 1)
            s.pop()


if __name__ == "__main__":
    dfs(1)
