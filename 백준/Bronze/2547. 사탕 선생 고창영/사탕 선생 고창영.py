import sys 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution(): 
    N = int(input())
    candies = [int(input()) for _ in range(N)]
    
    sum_candies = sum(candies)
    write("YES\n" if sum_candies % N == 0 else "NO\n")
    
        

if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        _ = input()
        solution()
