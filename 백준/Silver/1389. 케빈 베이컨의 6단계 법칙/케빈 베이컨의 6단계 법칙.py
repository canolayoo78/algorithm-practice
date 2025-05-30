import sys

input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    n, m = map(int, input().split())
    distances = [[INF if a != b else 0 for b in range(n)] for a in range(n)]
    for _ in range(m):
        start, end = map(int, input().split())
        distances[start - 1][end - 1] = 1
        distances[end - 1][start - 1] = 1

    for k in range(n):
        for start in range(n):
            for end in range(n):
                distances[start][end] = min(
                    distances[start][end], distances[start][k] + distances[k][end]
                )

    min_sum = INF
    min_index = 0
    for i in range(n):
        now_sum = sum(distances[i])
        if now_sum < min_sum:
            min_index = i
            min_sum = now_sum

    write(str(min_index + 1))


if __name__ == "__main__":
    solution()
