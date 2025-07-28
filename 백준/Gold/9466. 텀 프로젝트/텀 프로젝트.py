import sys
from collections import deque

input = sys.stdin.readline


def solution():
    def dfs(start):
        q = deque([start])
        group = set([start])

        while q:
            now = q.popleft()
            next = students[now]

            if next in group:
                cycle_end = next
                res = 0
                while True:
                    res += 1
                    visited[next] = -1
                    next = students[next]
                    if cycle_end == next:
                        return res

            if visited[next] == 0:
                q.append(next)
                group.add(next)
                visited[next] = 1

        return 0

    n = int(input())
    students = [0] + list(map(int, input().split()))
    visited = [0] * (n + 1)

    group_count = 0

    for i in range(1, n + 1):
        if visited[i] != -1:
            group_count += dfs(i)

    print(n - group_count)


if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        solution()
