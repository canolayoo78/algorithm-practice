import sys

input = sys.stdin.readline
print = sys.stdout.write


def solution():
    A, B = map(int, input().split())
    limit = int(B**0.5) + 1
    i_limit = limit // 2
    is_prime = [False] * i_limit
    primes = [2]

    for i in range(1, i_limit):
        if is_prime[i]:
            continue
        p = 2 * i + 1
        primes.append(p)

        for j in range(i, i_limit, p):
            is_prime[j] = True

    ans = 0
    for prime in primes:
        almost_prime = prime**2
        while almost_prime <= B:
            if almost_prime >= A:
                ans += 1
            almost_prime *= prime

    print(str(ans))


if __name__ == "__main__":
    solution()
