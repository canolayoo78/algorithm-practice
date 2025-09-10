import sys 

input = sys.stdin.readline 

def solution(): 
    N = int(input())
    round_1 = list(map(int, input().split()))
    round_2 = list(map(int, input().split()))

    print(sum(map(abs, round_1)) + sum(map(abs, round_2)))


if __name__ == "__main__":
    solution()
