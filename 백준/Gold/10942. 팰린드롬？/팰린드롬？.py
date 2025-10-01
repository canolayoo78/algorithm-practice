import sys 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution():
    N = int(input())
    numbers = list(map(int, input().split()))
    dp = [[0] * N for _ in range(N)]
    
    for i in range(N):
        dp[i][i] = 1
    for i in range(N-1):
        if numbers[i] == numbers[i + 1]: 
            dp[i][i+1]=1
                    
    for length in range(2, N):
        for i in range(N - length):
            j = i + length
            if numbers[i] == numbers[j] and dp[i + 1][j - 1]:
                dp[i][j] = 1
    
    M = int(input())
    for _ in range(M):
        s, e = map(int, input().split())
        print(dp[s-1][e-1])
    
    
    
if __name__ == "__main__":
    solution()
