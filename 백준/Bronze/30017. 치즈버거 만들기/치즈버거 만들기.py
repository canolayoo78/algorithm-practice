import sys 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution(): 
    N, M = map(int, input().split())
    if N <= M:
        write(str(2 * N - 1))  
    else:
        write(str(2 * M + 1))
     

if __name__ == "__main__":
    solution()

