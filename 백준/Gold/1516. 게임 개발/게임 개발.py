import sys

n = int(sys.stdin.readline())
build = [[0]]
for _ in range(n):
    li = list(map(int, sys.stdin.readline().split()))
    build.append(li[:-1])
dp = [-1] * (n + 1)

def check(idx):
    if dp[idx] != -1:
        return dp[idx]

    # 아직 방문하지 않은 건물
    ## 선행 건물 없다면
    if len(build[idx]) == 1:
        dp[idx] = build[idx][0]
        return dp[idx]

    ## 선행 건물 있는 경우
    ## 건물 i는 가장 늦게 끝나는 선행 건물이 끝나야 지을 수 있다
    prev_time = 0
    for prev in build[idx][1:]:
        prev_time = max(prev_time, check(prev))

    dp[idx] = prev_time + build[idx][0]
    return dp[idx]


for i in range(1, n + 1):
    print(check(i))



