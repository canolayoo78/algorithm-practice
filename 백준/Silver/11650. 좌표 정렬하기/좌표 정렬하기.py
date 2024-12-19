import sys

input = sys.stdin.readlines
print = sys.stdout.write

points = input()[1:]


def condition(line):
    x, y = map(int, line.split())
    return x + y / 1e6


points.sort(key=condition)
print("".join(points))
