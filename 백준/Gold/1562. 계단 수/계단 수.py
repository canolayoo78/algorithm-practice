import sys

input = sys.stdin.readline
write = sys.stdout.write

N = int(input())
dp = [[[0] * (2**10) for _ in range(10)] for _ in range(N+1)]

if N < 10:
  print(0)
    
else:
  for i in range(1, 10):
    dp[1][i][0 | (2**i)] = 1
    
  for length in range(2, N+1):
    for last in range(10):
      for bitmask in range(2**10):
        if last-1 >= 0:
          dp[length][last][bitmask | (2 ** last)] += dp[length-1][last-1][bitmask]
        if last + 1 <= 9:
          dp[length][last][bitmask | (2 ** last)] += dp[length-1][last+1][bitmask]
        
  ans = 0
  for i in range(10):
    ans += dp[N][i][-1]
    ans %= 1000000000
      
  print(ans)

