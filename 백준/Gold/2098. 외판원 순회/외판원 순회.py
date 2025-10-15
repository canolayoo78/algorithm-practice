import sys 
from collections import deque

input = sys.stdin.readline 
INF = sys.maxsize

def solution():
    n = int(input())
    graph = [list(map(int, input().split())) for _ in range(n)]
    dp = [[INF for _ in range(1<<n)] for _ in range(n)]
    
    dp[0][1] = 0
    q = deque([(0, 1)])
    answer = [INF for _ in range(n)]
    
    while q:
        now, mask =  q.popleft()
        if mask == (1<<n) - 1:
            if graph[now][0] != 0:
                answer[now] = dp[now][mask] + graph[now][0]
            else:
                dp[now][mask] = INF

        else:
            for next in range(1, n):
                if graph[now][next] and ((mask & (1 << next)) == 0):
                    new_mask = mask | (1<<next)
                    nd = dp[now][mask] + graph[now][next]
                    if nd < dp[next][new_mask]:
                        dp[next][new_mask] = nd
                        q.append((next, new_mask))
                        
    print(min(answer))
                    
if __name__ == "__main__":
    solution()