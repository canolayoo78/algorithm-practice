import sys
from collections import deque

N, K = map(int, sys.stdin.readline().rstrip().split())
visited = [-1] * 100001

q = deque([N])
visited[N] = 0
while q:
    now = q.popleft()
    if now == K:
        print(visited[now])
        exit()
    if 0 <= now-1 <= 100000 and visited[now-1] == -1:
        visited[now-1] = visited[now] + 1
        q.append(now-1)
    if 0 <= now*2 <= 100000 and visited[now*2] == -1:
        visited[now*2] = visited[now] + 0 	# Key Point
        q.appendleft(now*2) 				# Key Point
    if 0 <= now+1 <= 100000 and visited[now+1] == -1:
        visited[now+1] = visited[now] + 1
        q.append(now+1)