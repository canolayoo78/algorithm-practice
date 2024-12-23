import sys

input = sys.stdin.readline

N = int(input())
z_N = set(map(int, input().split()))

M = int(input())
z_M = map(int, input().split())

for key in z_M:
    print(int(key in z_N))
