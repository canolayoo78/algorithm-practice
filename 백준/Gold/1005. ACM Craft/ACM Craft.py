import sys 
from collections import deque 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution(): 
    N, K = map(int, input().split())
    construction = [0] + list(map(int, input().split()))
    graph = [[] for _ in range(N + 1)]
    dp = [0] * (N + 1)
    in_degree = [0] * (N + 1)
    for _ in range(K):
        X, Y = map(int, input().split())
        graph[X].append(Y)
        in_degree[Y] += 1
    W = int(input())
    q = deque([])

    for i in range(1, N+1):
        if in_degree[i] == 0:
            q.append(i)
            dp[i] = construction[i]

    while q:
        now = q.popleft()
        if now == W:
            break
        for next in graph[now]:
            dp[next] = max(dp[now] + construction[next], dp[next])
            in_degree[next] -= 1
            if in_degree[next] == 0:
                q.append(next)
                
    print(dp[W])
            
if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        solution()
