import sys 
from collections import deque 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution(): 
    N = int(input())
    graph = [[] for _ in range(N + 1)]
    in_degree = [0] * (N + 1)
    
    last_year = list(map(int,input().split()))
    for i in range(N):
        graph[last_year[i]].extend(last_year[i + 1:])
        in_degree[last_year[i]] = i
        
    M = int(input())
    for _ in range(M):
        a, b = map(int, input().split())
        if b in graph[a]:
            graph[a].remove(b)
            graph[b].append(a)
            in_degree[a] += 1
            in_degree[b] -= 1
        else:
            graph[b].remove(a)
            graph[a].append(b)
            in_degree[b] += 1
            in_degree[a] -= 1
    
    q = deque([])
    
    for i in range(1, N + 1):
        if in_degree[i] == 0:
            q.append(i)
    
    ans = []
    while q:
        if len(q) == 2:
            return "?"
        now = q.popleft()
        ans.append(now)
        for next in graph[now]:
            in_degree[next] -= 1
            if in_degree[next] == 0:
                q.append(next)
        
    if len(ans) == N:
        return " ".join(map(str, ans))
    
    else:
        return "IMPOSSIBLE"

if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        write(solution()+"\n")
