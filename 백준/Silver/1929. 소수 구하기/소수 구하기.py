import sys

# sys.setrecursionlimit(10000)

input = sys.stdin.readline
print = sys.stdout.write


def solution():
    M, N = map(int, input().split())
    i_limit = (N + 1) // 2
    check = [False] * i_limit
    primes = []

    if M <= 2:
        primes.append(2)

    for i in range(1, i_limit):
        if check[i]:
            continue
        p = 2 * i + 1
        if M <= p:
            primes.append(p)

        for j in range(i, i_limit, p):
            check[j] = True

    print("\n".join(str(prime) for prime in primes))


if __name__ == "__main__":
    solution()
