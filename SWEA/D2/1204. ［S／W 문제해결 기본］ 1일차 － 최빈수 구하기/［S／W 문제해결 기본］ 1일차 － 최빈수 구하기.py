MAX = 100
T = int(input())
for test_case in range(1, T + 1):
    tc = int(input())
    scores = map(int, input().split())
    counts = [0] * (MAX + 1)
    
    for s in scores: 
        counts[s] += 1
    
    max_count = 0
    max_score = 0
    for i in range(0, MAX + 1):
        if counts[i] >= max_count:
            max_count = counts[i] 
            max_score = i
    
    print(f"#{tc} {max_score}")
