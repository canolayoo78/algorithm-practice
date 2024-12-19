import sys

N = int(sys.stdin.readline())
numbers = [int(sys.stdin.readline()) for _ in range(N)]
numbers.sort()
for i in range(N):
    print(numbers[i])
