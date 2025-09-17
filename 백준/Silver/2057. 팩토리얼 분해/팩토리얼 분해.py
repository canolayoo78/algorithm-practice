import sys 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution(): 
    N = int(input().strip())

    factorials = []
    factorial = 1
    for i in range(21):
        if i > 0:
            factorial *= i
        factorials.append(factorial)

    possible = False
    for mask in range(1, 1 << 21): 
        total = 0
        for i in range(21):
            if mask & (1 << i):
                total += factorials[i]
        if total == N:
            possible = True
            break

    write("YES" if possible else "NO")

if __name__ == "__main__":
    solution()
