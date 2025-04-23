import sys
input = sys.stdin.readline

def gcd(a, b):
    if a%b == 0:
        return b
    return gcd(b, a %b)

def lcd(a, b):
    return (a*b) // gcd(a, b)

T = int(input())
for _ in range(T):
    A, B = map(int, input().split())
    print(lcd(A, B))