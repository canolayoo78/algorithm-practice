T = int(input())

for test_case in range(1, T + 1):
    N, L = map(int, input().split())
    ingredients = [list(map(int, input().split())) for _ in range(N)]
    answer = 0
    def dfs(idx, taste_sum, cal_sum):
        global answer
        if cal_sum > L:
            return
        if idx == N:
            answer = max(answer, taste_sum)
            return
        dfs(idx + 1, taste_sum + ingredients[idx][0], cal_sum + ingredients[idx][1])
        dfs(idx + 1, taste_sum, cal_sum)
        
    dfs(0, 0, 0) 
    print(f"#{test_case} {answer}")
        