T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    buildings = list(map(int, input().split()))
    ans = 0
    
    for i in range(2, N - 2):
        left = buildings[i-2:i]
        right = buildings[i+1:i+3]
        max_side = max(left + right)
        if max_side < buildings[i]:
            ans += (buildings[i] - max_side)

    print(f"#{test_case} {ans}")
