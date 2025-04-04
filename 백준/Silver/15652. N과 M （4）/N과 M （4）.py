import sys

input = sys.stdin.readline


def solution():
    N, M = map(int, input().split())
    stack = []

    def dfs(now):
        if len(stack) == M:
            print(" ".join(str(s) for s in stack))
            return
        for i in range(now, N + 1):
            stack.append(i)
            dfs(i)
            stack.pop()

    dfs(1)


if __name__ == "__main__":
    solution()
