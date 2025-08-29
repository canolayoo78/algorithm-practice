import sys

input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    N, S = map(int, input().split())
    num = list(map(int, input().split()))

    left = 0
    par_sum = 0
    ans = INF
    for right in range(N):
        par_sum += num[right]
        while par_sum >= S:
            ans = min(ans, right - left + 1)
            par_sum -= num[left]
            left += 1
    write("0" if ans == INF else str(ans))


if __name__ == "__main__":
    solution()
