import math
import sys

input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize
MOD = 1000000007


def solution():
    def build_tree():
        for i in range(1, N + 1):
            tree[leaf_start + i] = int(input())
        for i in range(leaf_start - 1, 0, -1):
            tree[i] = tree[2 * i] * tree[2 * i + 1] % MOD

    def update_tree(i):
        while i > 1:
            if i % 2 == 0:
                tree[i // 2] = tree[i] * tree[i + 1] % MOD
            else:
                tree[i // 2] = tree[i - 1] * tree[i] % MOD
            i //= 2

    def change_tree(index, value):
        tree[index] = value
        update_tree(index)

    def query(left, right):
        result = 1
        while left <= right:
            if left % 2 == 1:
                result = result * tree[left] % MOD
            if right % 2 == 0:
                result = result * tree[right] % MOD
            left = (left + 1) // 2
            right = (right - 1) // 2
        return result

    N, M, K = map(int, input().split())

    tree_height = math.ceil(math.log2(N))
    tree_size = 2 ** (tree_height + 1)
    tree = [1] * tree_size
    leaf_start = 2**tree_height - 1

    build_tree()

    for _ in range(M + K):
        q, b, c = map(int, input().split())
        if q == 1:
            change_tree(leaf_start + b, c)
        else:
            print(query(leaf_start + b, leaf_start + c))


if __name__ == "__main__":
    solution()
