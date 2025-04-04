import sys

input = sys.stdin.readline


def solution():
    N, M = map(int, input().split())
    stack = []

    def dfs():
        if len(stack) == M:
            print(" ".join(str(s) for s in stack))
            return
        for i in range(1, N + 1):
            if i not in stack:
                stack.append(i)
                dfs()
                stack.pop()

    dfs()


if __name__ == "__main__":
    solution()
