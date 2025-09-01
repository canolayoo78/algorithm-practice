import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    ans = 0
    for _ in range(5):
        ans += int(input())
    print(ans)


if __name__ == "__main__":
    solution()
