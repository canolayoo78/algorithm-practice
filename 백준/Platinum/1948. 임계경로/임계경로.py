import sys
from collections import deque

input = sys.stdin.readline


def solution():
    N = int(input())
    M = int(input())
    graph = [[] for _ in range(N + 1)]
    back_graph = [[] for _ in range(N + 1)]
    visit = [0] * (N + 1)
    in_degree = [0] * (N + 1)
    result = [0] * (N + 1)
    for _ in range(M):
        start, end, time = map(int, input().split())
        graph[start].append((end, time))
        back_graph[end].append((start, time))
        in_degree[end] += 1
    start, end = map(int, input().split())

    q = deque([start])

    while q:
        now = q.popleft()
        for next, time in graph[now]:
            result[next] = max(result[now] + time, result[next])
            in_degree[next] -= 1
            if in_degree[next] == 0:
                q.append(next)

    q.append(end)
    count = 0

    while q:
        now = q.popleft()
        for next, time in back_graph[now]:
            if result[now] - time == result[next]:
                count += 1
                if not visit[next]:
                    visit[next] = 1
                    q.append(next)

    print(result[end])
    print(count)


if __name__ == "__main__":
    solution()
