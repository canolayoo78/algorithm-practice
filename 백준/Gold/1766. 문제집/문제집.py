import sys 
import heapq

input = sys.stdin.readline 
write = sys.stdout.write 

def solution():
    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    indegree = [0] * (n+1)
    for _ in range(m):
        s, e = map(int, input().split())
        graph[s].append(e)
        indegree[e] += 1
    
    q = []
    for i in range(1, n+1):
        if indegree[i] == 0:
            heapq.heappush(q, i)
    
    while q:
        now = heapq.heappop(q)
        write(str(now)+" ")
        for next in graph[now]:
            indegree[next] -= 1
            if indegree[next] == 0:
                heapq.heappush(q, next)
    
    
if __name__ == "__main__":
    solution()
