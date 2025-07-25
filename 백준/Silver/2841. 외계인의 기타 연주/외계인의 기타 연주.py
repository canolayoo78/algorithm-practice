import sys
from collections import defaultdict

input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    N, _ = map(int, input().split())
    stacks = defaultdict(list)
    moves = 0

    def press(line, fret):
        nonlocal moves
        s = stacks[line]

        while s and s[-1] > fret:
            s.pop()
            moves += 1

        if s and s[-1] == fret:
            return

        s.append(fret)
        moves += 1

    for _ in range(N):
        line, fret = map(int, input().split())
        press(line, fret)

    print(moves)


if __name__ == "__main__":
    solution()
