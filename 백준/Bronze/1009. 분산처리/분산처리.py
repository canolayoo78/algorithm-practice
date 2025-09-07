import sys

input = sys.stdin.readline
write = sys.stdout.write

def solution(): 
    a, b = map(int,input().split())
    digit = a % 10
    cycle = []
    while digit not in cycle:
        cycle.append(digit)
        digit *= a
        digit %= 10
    ans = cycle[(b-1) % len(cycle)]
    write("10" if ans == 0 else str(ans))
    write("\n")


if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        solution()
