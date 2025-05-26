import sys

input = sys.stdin.readline


def solution():
    n = int(input())
    graph = [list(map(int, input().split())) for _ in range(n)]

    for k in range(n):
        for s in range(n):
            for e in range(n):
                if graph[s][k] and graph[k][e]:
                    graph[s][e] = 1

    for line in graph:
        print(*line)


if __name__ == "__main__":
    solution()
