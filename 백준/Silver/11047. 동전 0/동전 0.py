import sys

input = sys.stdin.readline


def solution():
    N, K = map(int, input().split())
    coin = [int(input()) for _ in range(N)]
    coin.sort(reverse=True)
    answer = 0

    for i in range(N):
        if K == 0:
            break
        if K < coin[i]:
            continue
        answer += K // coin[i]
        K %= coin[i]

    print(answer)


if __name__ == "__main__":
    solution()
