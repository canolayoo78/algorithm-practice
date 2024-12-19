import sys

N = int(sys.stdin.readline())
exist = [None] * 2000001

for _ in range(N):
    exist[int(sys.stdin.readline()) + 1000000] = 1

for i in range(len(exist)):
    if exist[i] == 1:
        print(i - 1000000)