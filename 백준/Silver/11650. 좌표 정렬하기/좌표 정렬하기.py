import sys

input = sys.stdin.readline
print = sys.stdout.write

N = int(input())

points = [tuple(map(int, input().split())) for _ in range(N)]

points.sort()

for x, y in points:
    print(str(x) + " " + str(y) + "\n")
