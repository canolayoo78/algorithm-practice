import sys 
import math

input = sys.stdin.readline 
write = sys.stdout.write 

def solution():
    n = int(input())
    ans = 0
    for i in range(1, math.ceil(n ** 0.5)):
        if n % i == 0:
            ans += 2
    if n % (n ** 0.5) == 0:
        ans += 1
    write(str(ans))
                   
if __name__ == "__main__":
    solution()