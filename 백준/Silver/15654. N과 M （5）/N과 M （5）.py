import sys

input = sys.stdin.readline
N, M = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()
s = []


def dfs():
    if len(s) == M:
        print(" ".join(str(number) for number in s))
        return

    for i in range(N):
        if numbers[i] not in s:
            s.append(numbers[i])
            dfs()
            s.pop()


if __name__ == "__main__":
    dfs()
