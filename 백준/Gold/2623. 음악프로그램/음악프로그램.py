import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
indegree = [0] * (N + 1)

def graph_init():
    for _ in range(M):
        order = list(map(int, input().split()))
        for i in range(1, len(order) - 1):
            start = order[i]
            end = order[i + 1]
            graph[start].append(end)
            indegree[end] += 1

def topological_sort(): 
    q = deque([])
    result = []
    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)
    
    while q:
        now = q.popleft()
        result.append(now)
        for i in graph[now]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)

    if len(result) == N:
        print("\n".join(str(r) for r in result))
    else:
        print(0)


graph_init()
topological_sort()
