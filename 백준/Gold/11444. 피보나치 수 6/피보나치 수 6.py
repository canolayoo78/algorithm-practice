import sys

input = sys.stdin.readline
write = sys.stdout.write
MOD = 1_000_000_007


def solution():
    N = int(input())

    def fibo(n):
        if n == 0:
            return (0, 1)

        a, b = fibo(n // 2)
        c = a * (2 * b - a)
        d = a**2 + b**2
        c, d = c % MOD, d % MOD

        if n % 2 == 0:
            return (c, d)
        else:
            return (d, (c + d) % MOD)

    print(fibo(N)[0])


if __name__ == "__main__":
    solution()
