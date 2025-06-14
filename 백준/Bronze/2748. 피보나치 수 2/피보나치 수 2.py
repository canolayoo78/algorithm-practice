import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    fibo = [0] * (N + 2)
    fibo[1], fibo[2] = 1, 1

    for i in range(3, N + 1):
        fibo[i] = fibo[i - 1] + fibo[i - 2]

    print(fibo[N])


if __name__ == "__main__":
    solution()
