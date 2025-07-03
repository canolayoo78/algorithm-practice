import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    _ = int(input())
    characters = list(map(int, input().split()))

    for c in characters:
        ans = 1
        if c < 300:
            ans += 1
        if c < 275:
            ans += 1
        if c < 250:
            ans += 1
        write(str(ans) + " ")


if __name__ == "__main__":
    solution()
