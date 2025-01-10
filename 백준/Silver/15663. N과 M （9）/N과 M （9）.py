import sys

input = sys.stdin.readline

N, M = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()
visited = [False] * N
s = []


def dfs():
    if len(s) == M:
        print(" ".join(str(number) for number in s))
        return

    check = 0
    for i in range(N):
        if not visited[i] and numbers[i] != check:
            s.append(numbers[i])
            visited[i] = True
            check = numbers[i]
            dfs()
            s.pop()
            visited[i] = False


if __name__ == "__main__":
    dfs()
