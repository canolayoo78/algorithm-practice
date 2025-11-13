T = 10
for test_case in range(1, T + 1):
    def multifly(m):
        if m == 1:
            return n
        else:
            return n * multifly(m-1)
        
    test_case = int(input())
    n, m = map(int, input().split())
    ans = multifly(m)
    print(f"#{test_case} {ans}")