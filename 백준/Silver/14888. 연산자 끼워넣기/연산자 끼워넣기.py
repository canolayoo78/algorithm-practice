N = int(input())
numbers = list(map(int, input().split()))
operator = list(map(int, input().split()))

min_ans = 10 ** 18
max_ans = -min_ans

def dfs(index, s, operator):
    global min_ans, max_ans
    
    if index == N:
        min_ans = min(min_ans, s)
        max_ans = max(max_ans, s)
        return

    if operator[0]:  
        dfs(index + 1, s + numbers[index], operator[:0] + [operator[0] - 1] + operator[1:])
    if operator[1]:   
        dfs(index + 1, s - numbers[index], operator[:1] + [operator[1] - 1] + operator[2:])
    if operator[2]:  
        dfs(index + 1, s * numbers[index], operator[:2] + [operator[2] - 1] + operator[3:])
    if operator[3]:
        dfs(index + 1, int(s / numbers[index]), operator[:3] + [operator[3] - 1])

dfs(1, numbers[0], operator)

print(f"{max_ans}\n{min_ans}")
