import sys
sys.setrecursionlimit(10000)

N = int(input())

def prime(i):
    for x in range(2, int((i**(1/2)))+1):
        if i % x == 0:
            return False
    return True
    
def DFS(i):
    if len(str(i)) == N:
        print(i)
    else:
        for x in range(1, 10, 2):
            if prime(i*10+x):
                DFS(i*10+x)
                   

DFS(2)
DFS(3)
DFS(5)
DFS(7)

    

        
    

        