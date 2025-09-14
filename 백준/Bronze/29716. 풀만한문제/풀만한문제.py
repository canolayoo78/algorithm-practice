import sys 

input = sys.stdin.readline 

def solution(): 
    J, N = map(int,input().split())
    problems = [input().strip() for _ in range(N)]
    
    def is_solvable(problem):
        size = 0
        for c in problem:
            if c.isupper():
                size += 4
            elif c.isspace():    
                size += 1
            else: 
                size += 2
        if size <= J:
            return True
        else:
            return False
    
    ans = 0
    for p in problems:
        if is_solvable(p):
            ans += 1
    print(ans)
            
if __name__ == "__main__":
    solution()
