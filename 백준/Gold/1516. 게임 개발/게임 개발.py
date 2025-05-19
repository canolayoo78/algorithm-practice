import sys
from collections import deque

input = sys.stdin.readline


def solution():
    N = int(input())
    graph = [[0]]
    dp = [-1] * (N + 1)
    for i in range(1, N + 1):
        build = list(map(int, input().split()))[:-1]
        graph.append(build)

    def check(idx):
        if dp[idx] != -1:
            return dp[idx]
        
        if len(graph[idx]) == 1:
            dp[idx] = graph[idx][0]
            return dp[idx]
        
        prev_time = 0
        for prev in graph[idx][1:]:
            prev_time = max(prev_time, check(prev))
            
        dp[idx] = prev_time + graph[idx][0]
        return dp[idx]
    
    

    print("\n".join(str(check(i)) for i in range(1, N + 1)))


if __name__ == "__main__":
    solution()
