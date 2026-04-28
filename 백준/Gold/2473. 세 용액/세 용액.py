import sys

input = sys.stdin.readline
MAX = sys.maxsize
N = int(input())
solutions = list(map(int, input().split()))
solutions.sort()

def solve():
    min_sum = MAX
    ans = [0, 0, 0]
    for i in range(N - 2):
        left, right = i + 1, N - 1
        while left < right:
            current_sum = solutions[i] + solutions[left] + solutions[right]
            if abs(current_sum) < abs(min_sum):
                min_sum = current_sum
                ans = [i, left, right]
            
            if current_sum < 0:
                left += 1
            elif current_sum > 0:
                right -= 1
            else:
                break

    result = " ".join(str(solutions[i]) for i in ans)
    print(result)
  
solve()