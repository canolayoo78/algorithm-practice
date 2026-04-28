import sys
from collections import deque

input = sys.stdin.readline
# print = sys.stdout.write

N = int(input())
graph = [[] for _ in range(N + 1)]
for _ in range(N):
    line = list(map(int, input().split()))
    start = line[0]
    for i in range(1, len(line) - 1, 2):
        graph[start].append((line[i], line[i + 1]))

distances = [0] * (N + 1)
visited = [False] * (N + 1)


def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = True
    while queue:
        now = queue.pop()
        next_nodes = graph[now]
        for next in next_nodes:
            node, dis = next
            if visited[node] is False:
                queue.append(node)
                visited[node] = True
                distances[node] = distances[now] + dis


bfs(1)
max = 1
max_index = 0

for i in range(N + 1):
    if distances[i] > max:
        max = distances[i]
        max_index = i

distances = [0] * (N + 1)
visited = [False] * (N + 1)
bfs(max_index)
distances.sort()
print(distances[N])
