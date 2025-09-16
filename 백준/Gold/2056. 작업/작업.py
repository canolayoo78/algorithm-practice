import sys 
from collections import deque 

input = sys.stdin.readline 

def solution(): 
    N = int(input())
    graph = [[] for _ in range(N + 1)]
    in_degree = [0] * (N + 1)
    work_time = [0] * (N + 1)
    dp = [0] * (N + 1)
    
    for i in range(1, N + 1):
        data = list(map(int, input().split()))
        work_time[i] = data[0]
        in_degree[i] = data[1]
        for node in data[2:]:
            graph[node].append(i)
        
    q = deque([])
    for i in range(1, N + 1):
        if in_degree[i] == 0:
            q.append(i)
            dp[i] = work_time[i]
    
    while q:
        now = q.popleft()
        for next in graph[now]:
            dp[next] = max(dp[next], dp[now] + work_time[next])
            in_degree[next] -= 1
            if in_degree[next] == 0:
                q.append(next)
    
    print(max(dp))
        
if __name__ == "__main__":
    solution()
