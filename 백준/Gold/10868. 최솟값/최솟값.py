import math
import sys

input = sys.stdin.readline
write = sys.stdout.write
INF = sys.maxsize


def solution():
    def build_tree():
        for i in range(N):
            tree[leaf_start + i] = int(input())
        for i in range(leaf_start - 1, 0, -1):
            tree[i] = min(tree[2 * i], tree[2 * i + 1])

    def query(l, r):
        l += leaf_start - 1
        r += leaf_start - 1
        result = INF
        while l <= r:
            if l % 2 == 1:
                result = min(result, tree[l])
                l += 1
            if r % 2 == 0:
                result = min(result, tree[r])
                r -= 1
            l //= 2
            r //= 2
        return result

    N, M = map(int, input().split())
    tree_height = math.ceil(math.log2(N))
    tree_size = 2 ** (tree_height + 1)
    tree = [INF] * tree_size
    leaf_start = 2**tree_height

    build_tree()

    for _ in range(M):
        a, b = map(int, input().split())
        print(query(a, b))


if __name__ == "__main__":
    solution()
