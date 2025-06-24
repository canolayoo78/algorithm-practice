import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    N = int(input())
    sticks = []
    for _ in range(N):
        sticks.append(int(input()))

    ans, max_h = 0, 0
    for s in sticks[::-1]:
        if s > max_h:
            ans += 1
            max_h = s
    print(ans)


if __name__ == "__main__":
    solution()
