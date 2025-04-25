import sys

input = sys.stdin.readline
print = sys.stdout.write


def solution():
    def is_palindrome(x):
        s = str(x)
        return s == s[::-1]

    def is_prime(x):
        for i in range(3, int(x**0.5) + 1, 2):
            if x % i == 0:
                return False
        return True

    N = int(input())

    if N <= 2:
        return 2

    if N % 2 == 0:
        N += 1

    while True:
        if is_palindrome(N):
            if is_prime(N):
                return N
        N += 2


if __name__ == "__main__":
    print(str(solution()))
