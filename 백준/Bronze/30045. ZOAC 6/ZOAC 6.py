import sys 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution(): 
    N = int(input())
    ans = 0
    for _ in range(N):
        s = input().strip()
        if "OI" in s or "01" in s:
            ans += 1
    write(str(ans))   
        

if __name__ == "__main__":
    solution()

