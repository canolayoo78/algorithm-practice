import sys 

input = sys.stdin.readline 
INF = sys.maxsize

def solution():
    N = int(input())
    features = list(map(int, input().split()))
    
    left, right = 0, N-1
    min_sum = INF
    min_index = (0,0)
    
    while left < right:
        now_sum = features[left] + features[right]
        if abs(now_sum) < abs(min_sum):
            min_sum = now_sum
            min_index = (left, right)
            if min_sum == 0:
                break
        if now_sum < 0:
            left += 1
        else:
            right -= 1
            
    print(features[min_index[0]], features[min_index[1]])
            
    
    
if __name__ == "__main__":
    solution()
