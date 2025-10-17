import sys 

input = sys.stdin.readline 

def solution():
    n = int(input())
    cards = set(map(int, input().split()))
    m = int(input())
    queries = list(map(int, input().split()))
             
    for q in queries:
        print("1" if q in cards else "0", end=" ")
                   
if __name__ == "__main__":
    solution()