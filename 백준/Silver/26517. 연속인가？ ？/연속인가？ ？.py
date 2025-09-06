import sys

input = sys.stdin.readline
write = sys.stdout.write

def solution(): 
    k = int(input())
    a, b, c, d = map(int, input().split())

    def f(k):
        return a * k + b
    
    ans = f(k)
    if ans == c * k + d:
        write("Yes "+str(ans))
    else:
        write("No")


if __name__ == "__main__":
    solution()
