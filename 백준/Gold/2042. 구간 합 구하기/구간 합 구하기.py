import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    def update_tree(i):
        while i > 1:
            if i % 2 == 0:
                segment_tree[i // 2] = segment_tree[i] + segment_tree[i + 1]
            else:
                segment_tree[i // 2] = segment_tree[i - 1] + segment_tree[i]
            i //= 2

    def change_leaf(b, c):
        segment_tree[b + n - 1] = c
        update_tree(b + n - 1)

    def calc_sum(b, c):
        start_index = b + n - 1
        end_index = c + n - 1
        sum = 0
        while start_index <= end_index:
            if start_index % 2 == 1:
                sum += segment_tree[start_index]
            if end_index % 2 == 0:
                sum += segment_tree[end_index]
            start_index = (start_index + 1) // 2
            end_index = (end_index - 1) // 2
        print(sum)

    N, M, K = map(int, input().split())
    n = 2
    while N > n:
        n *= 2
    segment_tree = [0] * (2 * n)
    for i in range(N):
        segment_tree[n + i] = int(input())

    for i in range(n - 1, 0, -1):
        segment_tree[i] = segment_tree[2 * i] + segment_tree[2 * i + 1]

    for _ in range(M + K):
        a, b, c = map(int, input().split())
        if a == 1:
            change_leaf(b, c)
        else:
            calc_sum(b, c)


if __name__ == "__main__":
    solution()
