import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    def is_safe(num):
        for i in range(2, 1000000):
            if num % i == 0:
                return "NO\n"
        return "YES\n"

    N = int(input())

    for _ in range(N):
        num = int(input())
        write(is_safe(num))


if __name__ == "__main__":
    solution()
