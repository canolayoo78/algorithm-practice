import sys

input = sys.stdin.readline
print = sys.stdout.write


def solution():
    A, B = map(int, input().split())

    def gcd(a, b):
        while b != 0:
            a, b = b, a % b
        return a

    print("1" * gcd(A, B))


if __name__ == "__main__":
    solution()
