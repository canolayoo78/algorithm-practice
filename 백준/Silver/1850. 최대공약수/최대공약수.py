import sys

input = sys.stdin.readline
print = sys.stdout.write


def solution():
    A, B = map(int, input().split())

    def gcd(a, b):
        while b != 0:
            a, b = b, a % b
        return a

    for _ in range(gcd(A, B)):
        print("1")


if __name__ == "__main__":
    solution()
