import sys 
import heapq

input = sys.stdin.readline 
write = sys.stdout.write 


def solution():
    N, K = map(int, input().split())
    jewels = []
    bags = []
    for _ in range(N):
        m, v = map(int, input().split())
        jewels.append((m, v))
    for _ in range(K):
        bags.append(int(input()))
    jewels.sort()
    bags.sort()
    
    q = []
    heapq.heapify(q)
    j, ans = 0, 0
    for i in range(K):
        while j < N and jewels[j][0] <= bags[i]:
            heapq.heappush(q, -jewels[j][1])
            j += 1
        if q:
            ans += -heapq.heappop(q)
        
    write(str(ans))
    
if __name__ == "__main__":
    solution()
