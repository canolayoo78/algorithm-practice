import sys

input = sys.stdin.readline
write = sys.stdout.write
MAX = sys.maxsize

C, N = map(int, input().split())
promo = [list(map(int, input().split())) for _ in range(N)]
dp = [0] * (C + 1)

for i in range(1, C + 1):
    min_invest = MAX
    for j in range(N):
        prev_c = 0 if (i - promo[j][1]) < 0 else  i - promo[j][1] 
        min_invest = min(min_invest, dp[prev_c] + promo[j][0])
    dp[i] = min_invest
print(dp[i])

