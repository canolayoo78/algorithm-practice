import sys

input = sys.stdin.readline


def solution():
    N = int(input())
    time_table = [tuple(map(int, input().split())) for _ in range(N)]

    time_table.sort(key=lambda x: (x[1], x[0]))

    last_end = 0
    ans = 0

    for n_start, n_end in time_table:
        if last_end <= n_start:
            ans += 1
            last_end = n_end

    print(ans)


if __name__ == "__main__":
    solution()
