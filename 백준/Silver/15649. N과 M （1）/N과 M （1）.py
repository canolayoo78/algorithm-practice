import sys

input = sys.stdin.readline
N, M = map(int, input().split())
s = []


def dfs():
    if len(s) == M:
        print(" ".join(str(number) for number in s))
        return

    for i in range(1, N + 1):
        if i not in s:
            s.append(i)
            dfs()
            s.pop()


if __name__ == "__main__":
    dfs()
